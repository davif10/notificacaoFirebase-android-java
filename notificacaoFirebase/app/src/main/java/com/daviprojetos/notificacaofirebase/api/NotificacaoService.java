package com.daviprojetos.notificacaofirebase.api;

import com.daviprojetos.notificacaofirebase.model.NotificacaoDados;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface NotificacaoService {
    @POST("send")
    Call<NotificacaoDados>salvarNotificacao(@Body NotificacaoDados notificacaoDados);
}
