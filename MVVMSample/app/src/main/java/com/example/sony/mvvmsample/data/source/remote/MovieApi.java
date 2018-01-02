package com.example.sony.mvvmsample.data.source.remote;

import com.example.sony.mvvmsample.data.model.ResponeModel;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Sony on 12/22/2017.
 */

public interface MovieApi {
    @GET("movie/popular")
    Observable<ResponeModel> getPopularMovie(@Query("api_key") String api_key, @Query("language") String language, @Query("page") String page);
}
