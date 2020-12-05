package com.daviprojetos.notificacaofirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /* Ativar tópicos(Exemplo : comidas)
        ()Mexicana
        ()Alemã
        (X)Brasileira
         */
        /*No firebase na hora de enviar a notificação
         selecionar a segmentação por tópico e selecionar o tópico desejado
         Nesse caso o usuário está se inscrevendo para receber mensagens de comida brasileira*/

        //Se inscrevendo no tópico de comida brasileira
        FirebaseMessaging.getInstance().subscribeToTopic("brasileira");

        //Desativando o tópico inscrito
        //FirebaseMessaging.getInstance().unsubscribeFromTopic("brasileira");

    }
}