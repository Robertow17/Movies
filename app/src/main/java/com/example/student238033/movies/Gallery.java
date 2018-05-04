package com.example.student238033.movies;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;


public class Gallery extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View v = inflater.inflate(R.layout.first_frag, container, false);

        prepareRecyclerView(v);
         return v;
    }

    private void prepareRecyclerView(View v) {
        RecyclerView recyclerView = (RecyclerView)v.findViewById(R.id.ImageGallery);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity().getApplicationContext(),2);
        recyclerView.setLayoutManager(layoutManager);
        ArrayList<Integer> createLists = getArguments().getIntegerArrayList("gallery");
        PhotoAdapter adapter = new PhotoAdapter(getActivity().getApplicationContext(), createLists);
        recyclerView.setAdapter(adapter);
    }

    public static Gallery newInstance(ArrayList<Integer> gallery) {

        Gallery f = new Gallery();
        Bundle b = new Bundle();
        b.putIntegerArrayList("gallery", gallery);
        f.setArguments(b);
        return f;
    }
}

