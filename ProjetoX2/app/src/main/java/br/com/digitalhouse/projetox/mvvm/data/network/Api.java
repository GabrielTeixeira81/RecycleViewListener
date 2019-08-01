package br.com.digitalhouse.projetox.mvvm.data.network;

import br.com.digitalhouse.projetox.mvvm.model.PessoasResp;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

@GET("api/")
    Single<PessoasResp> getPessoas(@Query("results") int total);
}
