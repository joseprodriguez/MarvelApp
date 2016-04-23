package edu.galileo.android.marvelapp.utilities.connection;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by José P. Rodríguez on 21/04/2016.
 */
public interface ConnectionService {
    @GET("/v1/public/characters")
    Call<Request> listCharacters(@Query("limit") int limit, @Query("ts") long t, @Query("hash") String h, @Query("apikey") String ak);

    @GET("/v1/public/characters")
    Call<Request> charByName(@Query("name") String name, @Query("ts") long t, @Query("hash") String h, @Query("apikey") String ak);
}
