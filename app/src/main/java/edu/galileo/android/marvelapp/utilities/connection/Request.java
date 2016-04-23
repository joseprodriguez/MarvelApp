package edu.galileo.android.marvelapp.utilities.connection;

/**
 * Created by José P. Rodríguez on 21/04/2016.
 */
public class Request {

    private String status;
    private Data data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
