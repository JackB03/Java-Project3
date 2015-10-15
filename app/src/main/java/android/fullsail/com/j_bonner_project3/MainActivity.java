package android.fullsail.com.j_bonner_project3;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.AdapterView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    ArrayAdapter<String> theAdapter;
    final String TAG = "MY MOVIE TAG";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Local Variables


        // Array List Information
        ArrayList<Movies> theMovies = new ArrayList<>();
        theMovies = new ArrayList<Movies>();
        theMovies.add(new Movies("Face Off", "Action", "1995"));
        theMovies.add(new Movies("Gladiator", "Drama", "2000"));
        theMovies.add(new Movies("Batman Begins", "Fantasy", "2005"));


        //boolean landOrientation = getResources().getBoolean(R.bool.landscapeMode);
        int orientation = this.getResources().getConfiguration().orientation;

        // When user is in Portrait
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            Spinner sv = (Spinner) findViewById(R.id.movieSpinnerView);

            //ADD SPINNER EVENT LISTENER
            sv.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    Log.i(TAG, "Item Selected");

                    Movies movie = (Movies) adapterView.getAdapter().getItem(i);
                    setInfo(movie.getName(),movie.getGenre(),movie.getYear());

                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                    Log.i(TAG, "Nothing Selected");
                }
            });


            ArrayAdapter<Movies> theAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, theMovies);

            sv.setAdapter(theAdapter);


        } else {
            // When user is in Landscape
            ListView movieListView = (ListView) findViewById(R.id.movieListView);

            movieListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Movies movie = (Movies) parent.getAdapter().getItem(position);

                    setInfo(movie.getName(), movie.getGenre(), movie.getYear());
                }
            });

            Adapter movieAdapter = new Adapter(this, theMovies);

            movieListView.setAdapter(movieAdapter);

        }

    }

    public void setInfo(String _name, String _genre, String _year) {

        int orientation = this.getResources().getConfiguration().orientation;

        if(orientation == Configuration.ORIENTATION_PORTRAIT) {

            TextView movieName = (TextView) findViewById(R.id.movie_name);
            TextView movieGenre = (TextView) findViewById(R.id.movie_genre);
            TextView movieYear = (TextView) findViewById(R.id.movie_year);

            movieName.setText(_name);
            movieGenre.setText(_genre);
            movieYear.setText(_year);


        } else {

            TextView movieName = (TextView) findViewById(R.id.land_movieName);
            TextView movieGenre = (TextView) findViewById(R.id.land_movieGenre);
            TextView movieYear = (TextView) findViewById(R.id.land_movieYear);

            movieName.setText(_name);
            movieGenre.setText(_genre);
            movieYear.setText(_year);


        }

    }
}


