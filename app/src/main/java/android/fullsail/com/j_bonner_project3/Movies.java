package android.fullsail.com.j_bonner_project3;

/**
 * Created by JackBonner on 9/17/15.
 */
public class Movies {

    private String mName;
    private String mGenre;
    private String mYear;

    public Movies (String _name, String _genre, String _year) {
        mName = _name;
        mGenre = _genre;
        mYear = _year;
    }

    public String getName() {
        return mName;
    }

    public String getGenre() {
        return mGenre;
    }

    public String getYear() {
        return mYear;
    }

}
