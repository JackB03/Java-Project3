package android.fullsail.com.j_bonner_project3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by JackBonner on 9/17/15.
 */
public class Adapter extends BaseAdapter {

    private static final long ID_CONSTANT = 0x010101010L;

    private Context mContext;
    private ArrayList<Movies> mMovies;

    public Adapter(Context _context, ArrayList<Movies> _movies) {
        mContext = _context;
        mMovies = _movies;
    }

    @Override
    public int getCount() {
        return mMovies.size();
    }

    @Override
    public Movies getItem(int _position) {
        return mMovies.get(_position);
    }


    @Override
    public long getItemId(int _position) {
        return ID_CONSTANT + _position;
    }

    @Override
    public View getView(int _position, View _convertView, ViewGroup _parent) {

        // If we don't have a recycled view, create a new view.
        if(_convertView == null) {
            // Creating the new view.
            _convertView = LayoutInflater.from(mContext).inflate(R.layout.movie_list, _parent, false);
        }

        // Get the object from the collection in an index-safe manner.
        Movies movies = getItem(_position);

        // Use the object from the collection to fill out our view.
        TextView tv = (TextView)_convertView.findViewById(R.id.movie_name);
        tv.setText(movies.getName());

        tv = (TextView)_convertView.findViewById(R.id.movie_genre);
        tv.setText(movies.getGenre());

        tv = (TextView)_convertView.findViewById(R.id.movie_year);
        tv.setText(movies.getYear());

        // Returning our filled out view.
        return _convertView;
    }
}
