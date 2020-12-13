package com.daviprojetos.notificacaofirebase.api;

import com.daviprojetos.notificacaofirebase.model.NotificacaoDados;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface NotificacaoService {
    /*
    Trocar a Key pela chave do servidor do Firebase
    Para pegar essa informação, no Firebase clicar em configurações do projeto ->
    Cloud Messaging -> copiar a Chave do Servidor
     */
    @Headers({
            "Authorization:key=AAAANdA-DWw:APA91bGe2Lipf0Q_sA_KuFl8ns5HSCFotGQMWY2DidcYaQhMuGOeqVx0W50bOXIbaoKXcutkJu3Dd8GsRQRgM512ScgFjoPUuwVtIsuPb3a78B-0L0mAVudyyJgZz1ZHy0S4z2paHeWf",
            "Content-Type:application/json"
    })
    @POST("send")
    Call<NotificacaoDados>salvarNotificacao(@Body NotificacaoDados notificacaoDados);
}
