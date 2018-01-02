package com.example.sony.mvvmsample.data.source.remote;

import android.app.Application;
import android.support.annotation.NonNull;

import com.example.sony.mvvmsample.util.Constant;

/**
 * Created by Sony on 12/22/2017.
 */

public class MovieServiceClient extends ServerClient{
    private static MovieApi mMovieApiInstance;

    public static void initialize(@NonNull Application application) {
        mMovieApiInstance = createService(application, Constant.BASE_URL, MovieApi.class);
    }

    public static MovieApi getInstance() {
        if (mMovieApiInstance == null) {
            throw new RuntimeException("Need call method NameServiceClient#initialize() first");
        }
        return mMovieApiInstance;
    }
}
