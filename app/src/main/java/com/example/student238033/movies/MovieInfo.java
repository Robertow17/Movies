package com.example.student238033.movies;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MovieInfo extends FragmentActivity
{
    ArrayList<Integer> gallery;
    ArrayList<Actor> actors;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_info);

        Intent i = getIntent();
        Movie movie = (Movie) i.getSerializableExtra("selectedMovie");
        setValuesFromSelectedMovie(movie);

        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
    }

    private void setValuesFromSelectedMovie(Movie movie) {
        gallery=movie.getGallery();
        actors=movie.getActors();

        TextView title = (TextView) findViewById(R.id.name);
        TextView genre = (TextView) findViewById(R.id.kind);
        ImageView cover = (ImageView) findViewById(R.id.cover);

        title.setText(movie.getTitle());
        genre.setText(movie.getGenre());
        cover.setImageResource(movie.getCover_id());
    }

    private class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int pos) {
            switch(pos) {

                case 0: return Gallery.newInstance(gallery);
                case 1: return ActorList.newInstance(actors);
                default: return ActorList.newInstance(actors);
            }
        }

        @Override
        public int getCount() {
            return 2;
        }
    }

}



