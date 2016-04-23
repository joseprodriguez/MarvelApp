package edu.galileo.android.marvelapp.utilities.connection;

import java.util.List;

/**
 * Created by José P. Rodríguez on 21/04/2016.
 */
public class Data {
    private List<SuperHeroe> results;
    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<SuperHeroe> getResults() {
        return results;
    }

    public void setResults(List<SuperHeroe> results) {
        this.results = results;
    }

}
