package com.example.sony.mvvmsample.screen;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.sony.mvvmsample.R;
import com.example.sony.mvvmsample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    MainViewModel mainViewModel;
    private static final String TAG = MainActivity.class.toString();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        mainViewModel = new MainViewModel();
        activityMainBinding.setViewmodel(mainViewModel);

    }
}
