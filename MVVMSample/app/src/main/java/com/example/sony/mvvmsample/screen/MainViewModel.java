package com.example.sony.mvvmsample.screen;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.Observable;
import android.databinding.ObservableField;
import android.util.Log;

import com.example.sony.mvvmsample.BR;
import com.example.sony.mvvmsample.data.model.Movie;
import com.example.sony.mvvmsample.data.source.MovieRepository;
import com.example.sony.mvvmsample.data.source.MovieRepositoryimpl;
import com.example.sony.mvvmsample.data.source.remote.MovieServiceClient;
import com.example.sony.mvvmsample.data.source.remote.RemoteDataSoure;
import com.example.sony.mvvmsample.util.Constant;

import java.util.List;

import rx.Subscriber;
import rx.schedulers.Schedulers;

/**
 * Created by Sony on 1/1/2018.
 */

public class MainViewModel extends BaseObservable {
    private static final String TAG = MainViewModel.class.toString();
    private MovieRepository movieRepository;


    @Bindable
    public MainAdapter getMainAdapter() {
        return mainAdapter;
    }

    public void setMainAdapter(MainAdapter mainAdapter) {
        this.mainAdapter = mainAdapter;
        notifyPropertyChanged(BR.mainAdapter);
    }

    private MainAdapter mainAdapter;


    public MainViewModel() {
        movieRepository = new MovieRepositoryimpl(null , new RemoteDataSoure(MovieServiceClient.getInstance()));
        movieRepository.searchPopularMovie(Constant.API_KEY_V3, Constant.LANGUAGE, "1").subscribeOn(Schedulers.io())
                .observeOn(rx.android.schedulers.AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<Movie>>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG ,"omCompleted");


                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, e.toString());

                    }

                    @Override
                    public void onNext(List<Movie> movies) {

                        Log.d(TAG, "onNext");
                        Log.d(TAG,movies.toString()+"jojo");
                        mainAdapter = new MainAdapter(movies);


                    }
                });



    }
}
