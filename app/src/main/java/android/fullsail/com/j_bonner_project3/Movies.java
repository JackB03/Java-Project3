package android.fullsail.com.j_bonner_project3;

public class Movies {

    private String mName;
    private String mGenre;
    private String mYear;

    public Movies () {
        mName = "";
        mGenre = "";
        mYear = "";
    }

    // Name
    public Movies(String _name) {
        this();
        mName = _name;
    }

    // Genre
    public Movies(String _name, String _genre) {
        this(_name);
        mGenre = _genre;
    }

    // Year
    public Movies(String _name, String _genre, String _year) {
        this(_name, _genre);
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

    public String toString() {
        return mName;
    }

}
