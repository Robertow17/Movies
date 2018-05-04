package com.example.student238033.movies;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;


public class ActorList extends Fragment {
    private ArrayList<Actor> actorsList = new ArrayList<>();
    private ActorAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.second_frag, container, false);

        getActorListFromArguments();
        prepareRecyclerView(v);
        return v;
    }

    private void prepareRecyclerView(View v) {
        RecyclerView recyclerView = (RecyclerView)v.findViewById(R.id.actors);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        adapter = new ActorAdapter(actorsList);
        recyclerView.setAdapter(adapter);
    }

    private void getActorListFromArguments() {
        int size = getArguments().getInt("length");
        for(Integer i=0; i<size; i++)
        {
            actorsList.add((Actor) getArguments().getSerializable("actor"+i.toString()));
        }
    }

    public static ActorList newInstance(ArrayList<Actor> actors) {

        ActorList f = new ActorList();
        Bundle b = new Bundle();

        b.putInt("length", actors.size());
        for (Integer j=0; j<actors.size(); j++)
        {
            b.putSerializable("actor"+ j.toString(),actors.get(j));
        }
        f.setArguments(b);
        return f;
    }
}
