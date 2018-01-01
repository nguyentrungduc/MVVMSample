package com.example.sony.mvvmsample.data.source.remote;

import com.example.sony.mvpsample.data.model.Movie;
import com.example.sony.mvpsample.data.model.ResponeModel;
import com.example.sony.mvpsample.data.source.DataSource;
import com.example.sony.mvpsample.util.Constant;

import java.util.List;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by Sony on 12/22/2017.
 */

public class RemoteDataSoure extends BaseRemoteDataSource implements DataSource.MovieRemoteDataSource {
    public RemoteDataSoure(MovieApi movieApi) {
        super(movieApi);
    }


    @Override
    public Observable<List<Movie>> searchPopularMovie(String key, String language, String page) {
        return mMovieApi.getPopularMovie(Constant.API_KEY_V3, Constant.LANGUAGE, "1")
                .flatMap(new Func1<ResponeModel, Observable<List<Movie>>>() {
                    @Override
                    public Observable<List<Movie>> call(ResponeModel responeModel) {
                        if (responeModel != null) {
                            return Observable.just(responeModel.getResults());
                        }
                        return Observable.error(new NullPointerException());
                    }


                });

    }
}
