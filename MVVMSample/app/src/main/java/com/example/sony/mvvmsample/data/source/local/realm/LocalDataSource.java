package com.example.sony.mvvmsample.data.source.local.realm;

import android.support.annotation.NonNull;

import com.example.sony.mvvmsample.data.model.Movie;
import com.example.sony.mvvmsample.data.source.DataSource;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmObject;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action2;

/**
 * Created by Sony on 12/22/2017.
 */

public class LocalDataSource implements DataSource.MovieLocalDataSource{

    RealmAPI mRealmApi;
    @Override
    public void openTransaction() {
        if (mRealmApi == null) {
            mRealmApi = new RealmAPI();
        }

    }

    @Override
    public void closeTransaction() {
        mRealmApi.closeRealmOnMainThread();

    }

    @Override
    public void openReadTransaction() {

    }

    @Override
    public Observable<Void> insertMovie(@NonNull final Movie movie) {
        return mRealmApi.realmTransactionAsync(new Action2<Subscriber<? super Void>, Realm>() {
            @Override
            public void call(Subscriber<? super Void> subscriber, Realm realm) {
                realm.insert(movie);
                subscriber.onCompleted();
            }
        });
    }

    @Override
    public Observable<Void> updateMovie(@NonNull final Movie movie) {
        return mRealmApi.realmTransactionAsync(new Action2<Subscriber<? super Void>, Realm>() {
            @Override
            public void call(Subscriber<? super Void> subscriber, Realm realm) {
                realm.insertOrUpdate(movie);
                subscriber.onCompleted();
            }
        });
    }

    @Override
    public Observable<Void> deleteMovie(@NonNull final Movie movie) {
        return mRealmApi.realmTransactionAsync(new Action2<Subscriber<? super Void>, Realm>() {
            @Override
            public void call(Subscriber<? super Void> subscriber, Realm realm) {
                RealmObject.deleteFromRealm(movie);
                subscriber.onCompleted();
            }
        });
    }

    @Override
    public Observable<Void> insertOrUpdateMovie(@NonNull final Movie movie) {
        return mRealmApi.realmTransactionAsync(new Action2<Subscriber<? super Void>, Realm>() {
            @Override
            public void call(Subscriber<? super Void> subscriber, Realm realm) {
                realm.insertOrUpdate(movie);
                subscriber.onCompleted();
            }
        });
    }

    @Override
    public Observable<List<Movie>> getAllMovie() {
        return null;
    }
}
