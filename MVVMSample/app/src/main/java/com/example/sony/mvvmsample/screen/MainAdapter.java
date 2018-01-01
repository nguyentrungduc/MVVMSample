package com.example.sony.mvvmsample.screen;

import android.content.Context;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.sony.mvvmsample.data.model.Movie;
import com.example.sony.mvvmsample.data.source.MovieRepository;

import java.util.List;

/**
 * Created by Sony on 1/1/2018.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder>{

    private List<Movie> mMovie;
    private Context context;

    public MainAdapter(List<Movie> mMovie) {
        this.mMovie = mMovie;
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MainViewHolder extends RecyclerView.ViewHolder {
        public MainViewHolder(View itemView) {
            super(itemView);
        }
    }
}
