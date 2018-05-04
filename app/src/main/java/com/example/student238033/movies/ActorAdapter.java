package com.example.student238033.movies;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ActorAdapter extends RecyclerView.Adapter<ActorAdapter.MyViewHolder>
{
    private List<Actor> actorsList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, age;
        public ImageView photo;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.title);
            age = (TextView) view.findViewById(R.id.genre);
            photo = (ImageView) view.findViewById(R.id.photo);
        }
    }

    public ActorAdapter(List<Actor> actorList) {
        this.actorsList = actorList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.actor_layout, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Actor actor = actorsList.get(position);
        holder.name.setText(actor.getName());
        holder.age.setText(actor.getAge());
        holder.photo.setImageResource(actor.getPhoto_id());
    }

    @Override
    public int getItemCount() {
        return actorsList.size();
    }
}
