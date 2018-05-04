package com.example.student238033.movies;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class FilmList extends AppCompatActivity implements RecyclerMovieTouchHelper.RecyclerItemTouchHelperListener {

    private List<Movie> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MovieAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_list);

        prepareToolbar();
        prepareRecyclerView();
        prepareMovieData();
        prepareItemTouchHelper();
    }

    private void prepareToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getString(R.string.app_name));
    }

    private void prepareItemTouchHelper() {
        ItemTouchHelper.SimpleCallback itemTouchHelperCallback = new RecyclerMovieTouchHelper(0, ItemTouchHelper.LEFT, this);
        new ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(recyclerView);

        ItemTouchHelper.SimpleCallback itemTouchHelperCallback1 = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT | ItemTouchHelper.UP) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {}

            @Override
            public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
            }
        };
        new ItemTouchHelper(itemTouchHelperCallback1).attachToRecyclerView(recyclerView);
    }

    private void prepareRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.list);
        adapter = new MovieAdapter(movieList, this);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(adapter);
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Movie movie = movieList.get(position);
                Intent i = new Intent(FilmList.this, MovieInfo.class);
                i.putExtra("selectedMovie", movie);
                startActivity(i);

            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
    }

    private void prepareMovieData() {

        ArrayList<Integer> incepcja_gallery = new ArrayList<>();
        incepcja_gallery.add(R.drawable.incepcja1);
        incepcja_gallery.add(R.drawable.incepcja2);
        incepcja_gallery.add(R.drawable.incepcja3);
        incepcja_gallery.add(R.drawable.incepcja4);
        incepcja_gallery.add(R.drawable.incepcja5);
        incepcja_gallery.add(R.drawable.incepcja6);
        incepcja_gallery.add(R.drawable.incepcja7);
        incepcja_gallery.add(R.drawable.incepcja8);

        ArrayList<Actor> incepcja_actors = new ArrayList<>();
        incepcja_actors.add(new Actor("Leonardo DiCaprio", "43", R.drawable.leonardo_dicaprio));
        incepcja_actors.add(new Actor("Joseph Gordon-Levitt", "37", R.drawable.joseph_gordon_levitt));
        incepcja_actors.add(new Actor("Ellen Page", "31", R.drawable.ellen_page));
        incepcja_actors.add(new Actor("Tom Hardy I", "40", R.drawable.tom_hardy));
        incepcja_actors.add(new Actor("Marion Cotillard", "42", R.drawable.marion_cotillard));

        Movie movie = new Movie("Incepcja", "Thriller, Sci-Fi", R.drawable.incepcja_photo, R.drawable.incepcja_cover, incepcja_gallery,incepcja_actors);
        movieList.add(movie);

        ArrayList<Integer> siedem_dusz_gallery = new ArrayList<>();
        siedem_dusz_gallery.add(R.drawable.siedemdusz1);
        siedem_dusz_gallery.add(R.drawable.siedemdusz2);
        siedem_dusz_gallery.add(R.drawable.siedemdusz3);
        siedem_dusz_gallery.add(R.drawable.siedemdusz4);
        siedem_dusz_gallery.add(R.drawable.siedemdusz5);
        siedem_dusz_gallery.add(R.drawable.siedemdusz6);
        siedem_dusz_gallery.add(R.drawable.siedemdusz7);
        siedem_dusz_gallery.add(R.drawable.siedemdusz8);

        ArrayList<Actor> siedem_dusz_actors= new ArrayList<>();
        siedem_dusz_actors.add(new Actor("Will Smith I", "49", R.drawable.will_smith));
        siedem_dusz_actors.add(new Actor("Rosario Dawson", "38", R.drawable.rosario_dawson));
        siedem_dusz_actors.add(new Actor("Woody Harrelson", "56", R.drawable.woody_herrelson));
        siedem_dusz_actors.add(new Actor("Michael Ealy", "44", R.drawable.michael_ealy));

        Movie movie1 = new Movie("Siedem dusz", "Dramat", R.drawable.siedemdusz_photo, R.drawable.siedemdusz_cover, siedem_dusz_gallery,siedem_dusz_actors);
        movieList.add(movie1);

        ArrayList<Integer> mroczny_rycerz_gallery = new ArrayList<>();
        mroczny_rycerz_gallery.add(R.drawable.mroczny_rycerz1);
        mroczny_rycerz_gallery.add(R.drawable.mroczny_rycerz2);
        mroczny_rycerz_gallery.add(R.drawable.mroczny_rycerz3);
        mroczny_rycerz_gallery.add(R.drawable.mroczny_rycerz4);
        mroczny_rycerz_gallery.add(R.drawable.mroczny_rycerz5);
        mroczny_rycerz_gallery.add(R.drawable.mroczny_rycerz6);
        mroczny_rycerz_gallery.add(R.drawable.mroczny_rycerz7);
        mroczny_rycerz_gallery.add(R.drawable.mroczny_rycerz8);

        ArrayList<Actor> mroczny_rycerz_actors= new ArrayList<>();
        mroczny_rycerz_actors.add(new Actor("Christian Bale", "44", R.drawable.christian_bale));
        mroczny_rycerz_actors.add(new Actor("Heath Ledger", "[*] 22 stycznia 2008", R.drawable.heath_ledger));
        mroczny_rycerz_actors.add(new Actor("Aaron Eckhart", "50", R.drawable.aaron_eckhart));
        mroczny_rycerz_actors.add(new Actor("Michael Caine I", "85", R.drawable.michael_caine));
        mroczny_rycerz_actors.add(new Actor("Gary Oldman", "60", R.drawable.gary_oldman));

        Movie movie2 = new Movie("Mroczny Rycerz", "Akcja, Sci-Fi", R.drawable.mroczny_rycerz_photo,R.drawable.mroczny_rycerz_cover, mroczny_rycerz_gallery,mroczny_rycerz_actors);
        movieList.add(movie2);

        ArrayList<Integer> zielona_mila_gallery = new ArrayList<>();
        zielona_mila_gallery.add(R.drawable.zielona_mila1);
        zielona_mila_gallery.add(R.drawable.zielona_mila2);
        zielona_mila_gallery.add(R.drawable.zielona_mila3);
        zielona_mila_gallery.add(R.drawable.zielona_mila4);
        zielona_mila_gallery.add(R.drawable.zielona_mila5);
        zielona_mila_gallery.add(R.drawable.zielona_mila6);
        zielona_mila_gallery.add(R.drawable.zielona_mila7);
        zielona_mila_gallery.add(R.drawable.zielona_mila8);

        ArrayList<Actor> zielona_mila_actors= new ArrayList<>();
        zielona_mila_actors.add(new Actor("Tom Hanks", "61", R.drawable.tom_hanks));
        zielona_mila_actors.add(new Actor("David Morse I", "64", R.drawable.david_morse));
        zielona_mila_actors.add(new Actor("Bonnie Hunt", "56", R.drawable.bonnie_hunt));
        zielona_mila_actors.add(new Actor("Michael Clarke Duncan", "3 września 2012 (54)", R.drawable.michael_clarke_duncan));


        Movie movie3 = new Movie("Zielona mila", "Dramat", R.drawable.zielona_mila_photo,R.drawable.zielona_mila_cover, zielona_mila_gallery,zielona_mila_actors);
        movieList.add(movie3);

        ArrayList<Integer> adwokat_diabla_gallery = new ArrayList<>();
        adwokat_diabla_gallery.add(R.drawable.adwokat_diabla1);
        adwokat_diabla_gallery.add(R.drawable.adwokat_diabla2);
        adwokat_diabla_gallery.add(R.drawable.adwokat_diabla3);
        adwokat_diabla_gallery.add(R.drawable.adwokat_diabla4);
        adwokat_diabla_gallery.add(R.drawable.adwokat_diabla5);
        adwokat_diabla_gallery.add(R.drawable.adwokat_diabla6);
        adwokat_diabla_gallery.add(R.drawable.adwokat_diabla7);
        adwokat_diabla_gallery.add(R.drawable.adwokat_diabla8);

        ArrayList<Actor> adwokat_diabla_actors= new ArrayList<>();
        adwokat_diabla_actors.add(new Actor("Keanu Reeves", "53", R.drawable.keanu_reeves));
        adwokat_diabla_actors.add(new Actor("Al Pacino I", "77", R.drawable.al_pacino));
        adwokat_diabla_actors.add(new Actor("Charlize Theron", "42", R.drawable.charlize_theron));
        adwokat_diabla_actors.add(new Actor("Jeffrey Jones I", "71", R.drawable.jeffrey_jones));

        Movie movie4 = new Movie("Adwokat diabła", "Thriller", R.drawable.adwokat_diabla_photo,R.drawable.adwokat_diabla_cover, adwokat_diabla_gallery,adwokat_diabla_actors);
        movieList.add(movie4);

        ArrayList<Integer> forrest_gump_gallery = new ArrayList<>();
        forrest_gump_gallery.add(R.drawable.forrest_gump1);
        forrest_gump_gallery.add(R.drawable.forrest_gump2);
        forrest_gump_gallery.add(R.drawable.forrest_gump3);
        forrest_gump_gallery.add(R.drawable.forrest_gump4);
        forrest_gump_gallery.add(R.drawable.forrest_gump5);
        forrest_gump_gallery.add(R.drawable.forrest_gump6);
        forrest_gump_gallery.add(R.drawable.forrest_gump7);
        forrest_gump_gallery.add(R.drawable.forrest_gump8);

        ArrayList<Actor> forrest_gump_actors= new ArrayList<>();
        forrest_gump_actors.add(new Actor("Tom Hanks", "61", R.drawable.tom_hanks));
        forrest_gump_actors.add(new Actor("Robin Wright V", "52", R.drawable.robin_wright));
        forrest_gump_actors.add(new Actor("Gary Sinise", "63", R.drawable.gary_sinise));
        forrest_gump_actors.add(new Actor("Sally Field", "71", R.drawable.sally_field));

        Movie movie5 = new Movie("Forrest Gump", "Dramat, Komedia", R.drawable.forrest_gump_photo,R.drawable.forrest_gump_cover, forrest_gump_gallery,forrest_gump_actors);
        movieList.add(movie5);

        adapter.notifyDataSetChanged();
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction, int position) {
        if (viewHolder instanceof MovieAdapter.MyViewHolder) {
            String title = movieList.get(viewHolder.getAdapterPosition()).getTitle();
            adapter.removeMovie(viewHolder.getAdapterPosition());
            Toast.makeText(FilmList.this, "Usunięto " + title + "!", Toast.LENGTH_SHORT).show();
        }
    }

    public interface ClickListener
    {
        void onClick(View view, int position);
        void onLongClick(View view, int position);
    }

    public static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

        private GestureDetector gestureDetector;
        private FilmList.ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final FilmList.ClickListener clickListener) {
            this.clickListener = clickListener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && clickListener != null) {
                        clickListener.onLongClick(child, recyclerView.getChildPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
                clickListener.onClick(child, rv.getChildPosition(child));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }

}
