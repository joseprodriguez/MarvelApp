package edu.galileo.android.marvelapp.utilities.connection;

import android.app.ProgressDialog;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.security.MessageDigest;
import java.util.Date;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by José P. Rodríguez on 21/04/2016.
 */
public class ConexionAPI {
    private static final String CHARACTERS_URL = "http://gateway.marvel.com";
    public static final String PUBLIC_KEY = "b051958471a711b3c32ca2310482fced";
    private static final String PRIVATE_KEY = "837bfebbc496eb664f477786afb2a1f2f58f35a9";
    private static final Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").create();
    private static final Retrofit retrofitClient = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create(gson)).baseUrl(CHARACTERS_URL).build();
    public static final ConnectionService service = retrofitClient.create(ConnectionService.class);

    public static Hashing getHash() {
        String hash = "";
        StringBuffer sb;
        long timestamp = new Date().getTime();
        String original = timestamp + PRIVATE_KEY + PUBLIC_KEY;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(original.getBytes());
            byte[] digest = md.digest();
            sb= new StringBuffer();
            for (byte b : digest) {
                sb.append(String.format("%02x", b & 0xff));
            }
            hash = new String(sb.toString());
        }catch(Exception e){
            e.printStackTrace();
        }
        return new Hashing(hash, timestamp);
    }

    public void initTask() {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        Retrofit retrofitClient = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(CHARACTERS_URL)
                .build();

        ConnectionService service = retrofitClient.create(ConnectionService.class);

        String hash = "";
        StringBuffer sb;
        long timestamp = new Date().getTime();
        String original = timestamp + PRIVATE_KEY + PUBLIC_KEY;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(original.getBytes());
            byte[] digest = md.digest();
            sb= new StringBuffer();
            for (byte b : digest) {
                sb.append(String.format("%02x", b & 0xff));
            }
            hash = new String(sb.toString());
        }catch(Exception e){
            e.printStackTrace();
        }

        Call<Request> requestResultCall = service.listCharacters(2, timestamp, hash, PUBLIC_KEY);
        requestResultCall.enqueue(new Callback<Request>() {
            @Override
            public void onResponse(Response<Request> response, Retrofit retrofit) {
                String nombre = response.body().getData().getResults().get(0).getName();
                Log.e("ya!", nombre);
                if (response.isSuccess()) {

                } else {

                }
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }
}
