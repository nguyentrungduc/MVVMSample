package com.example.sony.mvvmsample.data.model;

import io.realm.RealmObject;

/**
 * Created by Sony on 12/22/2017.
 */

public class RealmInteger extends RealmObject{

    private int val;

    public RealmInteger() {
    }

    public RealmInteger(int val) {
        this.val = val;
    }
}
