package com.daviprojetos.notificacaofirebase;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(@NonNull RemoteMessage notificacao) {
        if(notificacao.getNotification() != null){
            String titulo = notificacao.getNotification().getTitle();
            String corpo = notificacao.getNotification().getBody();

            enviarNotificacao(titulo,corpo);
            //System.out.println("Titulo: "+titulo+"\n Corpo: "+corpo);
        }
    }

    @Override
    public void onNewToken(@NonNull String s) {
        super.onNewToken(s);
    }

    private void enviarNotificacao(String titulo, String corpo){
        //Configurações para notificação
        String canal = getString(R.string.default_notification_channel_id);
        Uri uriSom = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        Intent intent = new Intent(this,NotificacoesActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0, intent,PendingIntent.FLAG_ONE_SHOT);

        //Criar notificação
        NotificationCompat.Builder notificacao = new NotificationCompat.Builder(this,canal)
                .setContentTitle(titulo)
                .setContentText(corpo)
                .setSmallIcon(R.drawable.ic_camera_preto_24)
                .setSound(uriSom)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent);

        //Recuperar notificationManager
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        //Verifica versão do Android a partir do Oreo para configurar canal de notificação
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel(canal,"canal",NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(channel);
        }

        //Envia notificação
        notificationManager.notify(0,notificacao.build());
    }
}
