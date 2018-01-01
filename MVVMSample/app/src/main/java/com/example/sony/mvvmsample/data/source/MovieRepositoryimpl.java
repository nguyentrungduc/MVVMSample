package com.example.sony.mvvmsample.data.source;

import android.support.annotation.NonNull;

import com.example.sony.mvvmsample.data.model.Movie;
import com.example.sony.mvvmsample.data.source.local.realm.LocalDataSource;

import java.util.List;

import rx.Observable;

/**
 * Created by Sony on 12/22/2017.
 */

public class MovieRepositoryimpl implements MovieRepository {
    private DataSource.MovieLocalDataSource mLocalDataSource;
    private DataSource.MovieRemoteDataSource mRemoteDataSource;

    public MovieRepositoryimpl(LocalDataSource localDataSource,
                               DataSource.MovieRemoteDataSource remoteDataSource) {
        mLocalDataSource = localDataSource;
        mRemoteDataSource = remoteDataSource;
    }


    @Override
    public Observable<Void> insertMovie(@NonNull Movie movie) {
        return mLocalDataSource.insertMovie(movie);
    }

    @Override
    public Observable<Void> updateMovie(@NonNull Movie movie) {
        return mLocalDataSource.updateMovie(movie);
    }

    @Override
    public Observable<Void> deleteMovie(@NonNull Movie movie) {
        return mLocalDataSource.deleteMovie(movie);
    }

    @Override
    public Observable<Void> insertOrUpdateMovie(@NonNull Movie movie) {
        return mLocalDataSource.insertOrUpdateMovie(movie);
    }

    @Override
    public Observable<List<Movie>> getAllMovie() {
        return mLocalDataSource.getAllMovie();
    }

    @Override
    public Observable<List<Movie>> searchPopularMovie(String key, String language, String page) {
        return mRemoteDataSource.searchPopularMovie(key, language, page);
    }
}
