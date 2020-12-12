package com.daviprojetos.notificacaofirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.daviprojetos.notificacaofirebase.api.NotificacaoService;
import com.daviprojetos.notificacaofirebase.model.Notificacao;
import com.daviprojetos.notificacaofirebase.model.NotificacaoDados;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.google.firebase.messaging.FirebaseMessaging;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private Retrofit retrofit;
    private String baseUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        baseUrl = "https://fcm.googleapis.com/fcm/";
        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        /* Ativar tópicos(Exemplo : comidas)
        ()Mexicana
        ()Alemã
        (X)Brasileira
         */
        /*No firebase na hora de enviar a notificação
         selecionar a segmentação por tópico e selecionar o tópico desejado
         Nesse caso o usuário está se inscrevendo para receber mensagens de comida brasileira

        //Se inscrevendo no tópico de comida brasileira
        FirebaseMessaging.getInstance().subscribeToTopic("brasileira");

        //Desativando o tópico inscrito
        //FirebaseMessaging.getInstance().unsubscribeFromTopic("brasileira");

         */

    }

    public void recuperarToken(View view){
        FirebaseInstanceId.getInstance().getInstanceId().addOnSuccessListener(new OnSuccessListener<InstanceIdResult>() {
            @Override
            public void onSuccess(InstanceIdResult instanceIdResult) {
                String token = instanceIdResult.getToken();
                Log.i("onNewToken","onNewToken: "+token);
                System.out.println("TOKEN RECUPERADO: "+token);

            }
        });
    }

    public void enviarNotificacao(View view){
        String to=""; //Tópico ou Token
        Notificacao notificacao = new Notificacao("Título da notificação!","Corpo notificação");
        //Monta objeto notificação
        NotificacaoDados notificacaoDados = new NotificacaoDados(to,notificacao);

        NotificacaoService service = retrofit.create(NotificacaoService.class);
        Call<NotificacaoDados> call = service.salvarNotificacao(notificacaoDados);

        call.enqueue(new Callback<NotificacaoDados>() {
            @Override
            public void onResponse(Call<NotificacaoDados> call, Response<NotificacaoDados> response) {

            }

            @Override
            public void onFailure(Call<NotificacaoDados> call, Throwable t) {

            }
        });
    }

}