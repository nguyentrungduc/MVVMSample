package com.example.sony.mvvmsample.screen;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sony.mvvmsample.R;
import com.example.sony.mvvmsample.data.model.Movie;
import com.example.sony.mvvmsample.data.source.MovieRepository;
import com.example.sony.mvvmsample.databinding.ItemMovieBinding;

import java.util.List;

/**
 * Created by Sony on 1/1/2018.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder>{

    private static final String TAG = MainAdapter.class.toString();
    private List<Movie> mMovie;

    public MainAdapter(List<Movie> mMovie) {
        this.mMovie = mMovie;

        Log.d(TAG,"contrustor adapter");
        Log.d(TAG, "list movie" +mMovie.toString());
    }

    private MovieClickListenner mMovieClickListener;



    public void setItemClickListener(MovieClickListenner movieClickListener) {
        mMovieClickListener = movieClickListener;
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemMovieBinding itemMovieBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_movie,parent,false
        );
        return new MainViewHolder(itemMovieBinding);
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, int position) {
        holder.bindData(mMovie.get(position));
    }

    @Override
    public int getItemCount() {
        return mMovie.size();
    }

    public class MainViewHolder extends RecyclerView.ViewHolder {

        private ItemMovieBinding itemMovieBinding;
        public MainViewHolder(ItemMovieBinding itemView) {
            super(itemView.getRoot());
            itemMovieBinding = itemView;
        }

        public void bindData(Movie movie){
            itemMovieBinding.setMovie(movie);
            itemMovieBinding.setListener(mMovieClickListener);

        }
    }
}
