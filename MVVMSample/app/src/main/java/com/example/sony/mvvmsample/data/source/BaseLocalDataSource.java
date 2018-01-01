package com.example.sony.mvvmsample.data.source;

/**
 * Created by Sony on 12/22/2017.
 */

public interface BaseLocalDataSource {
    void openTransaction();

    void closeTransaction();

    void openReadTransaction();
}
