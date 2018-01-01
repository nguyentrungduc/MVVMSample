package com.example.sony.mvvmsample.data.source;

import android.support.annotation.NonNull;

import com.example.sony.mvvmsample.data.model.Movie;

import java.util.List;

import rx.Observable;

/**
 * Created by Sony on 12/22/2017.
 */

public interface DataSource {

    interface MovieLocalDataSource extends BaseLocalDataSource {

        Observable<Void> insertMovie(@NonNull Movie movie);

        Observable<Void> updateMovie(@NonNull Movie movie);

        Observable<Void> deleteMovie(@NonNull Movie movie);

        Observable<Void> insertOrUpdateMovie(@NonNull Movie movie);

        Observable<List<Movie>> getAllMovie();


    }


    interface MovieRemoteDataSource {
        Observable<List<Movie>> searchPopularMovie(String key, String language, String page);
    }
}
