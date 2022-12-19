package com.mustafa.mymovies.Controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.mustafa.mymovies.Model.Movie;
import com.mustafa.mymovies.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Movie> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MoviesAdapter moviesAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        moviesAdapter = new MoviesAdapter(movieList);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(moviesAdapter);

        MoviesData();
    }

    private void MoviesData() {
        Movie movie = new Movie("Brids of prey","Action","2020");
        movieList.add(movie);

        Movie movie2 = new Movie("Shakara","Drama","2019");
        movieList.add(movie2);

        Movie movie3 = new Movie("Malang","Action","2018");
        movieList.add(movie3);

        Movie movie4 = new Movie("come to Daddy","Drama","2019");
        movieList.add(movie4);

        Movie movie5 = new Movie("And then we Danced","Action","2018");
        movieList.add(movie5);

        Movie movie6 = new Movie("Legend of Defication","Drama","2019");
        movieList.add(movie6);

        Movie movie7 = new Movie("waiting for Anay","Action","2018");
        movieList.add(movie7);

        Movie movie8 = new Movie("Brids of prey","war","2019");
        movieList.add(movie8);

        moviesAdapter.notifyDataSetChanged();
    }
}