package edu.galileo.android.marvelapp.utilities.connection;

/**
 * Created by José P. Rodríguez on 21/04/2016.
 */
public class Hashing {
    private String hashcode;
    private long ts;

    public Hashing(String h, long t) {
        this.hashcode = h;
        this.ts = t;
    }

    public long getTs() {
        return ts;
    }

    public void setTs(long ts) {
        this.ts = ts;
    }

    public String getHashcode() {
        return hashcode;
    }

    public void setHashcode(String hashcode) {
        this.hashcode = hashcode;
    }
}