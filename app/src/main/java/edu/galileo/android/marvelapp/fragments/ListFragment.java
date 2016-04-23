package edu.galileo.android.marvelapp.fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import edu.galileo.android.marvelapp.R;
import edu.galileo.android.marvelapp.activities.DetailsActivity;
import edu.galileo.android.marvelapp.adapter.OnItemClickListener;
import edu.galileo.android.marvelapp.adapter.SuperAdapter;
import edu.galileo.android.marvelapp.utilities.connection.ConexionAPI;
import edu.galileo.android.marvelapp.utilities.connection.Hashing;
import edu.galileo.android.marvelapp.utilities.connection.Request;
import edu.galileo.android.marvelapp.utilities.connection.SuperHeroe;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by José P. Rodríguez on 1/03/2016.
 */
public class ListFragment extends Fragment implements OnItemClickListener {
    private RecyclerView recyclerView;
    private SuperAdapter adaptador;
    private final static String TAG = "FragmentoLista";
    public final static String INFO_SUPER = "informacion_del_personaje";
    private final String[] nombres = {"spider-man", "thor", "hulk", "black widow", "wolverine", "captain america"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        for(String n : nombres) {
            Hashing h = ConexionAPI.getHash();
            Call<Request> requestResultCall = ConexionAPI.service.charByName(n, h.getTs(), h.getHashcode(), ConexionAPI.PUBLIC_KEY);
            requestResultCall.enqueue(new Callback<Request>() {

                @Override
                public void onResponse(Response<Request> response, Retrofit retrofit) {
                    List<SuperHeroe> l = response.body().getData().getResults();
                    for(SuperHeroe s : l) {
                        adaptador.addNew(s);
                    }
                    /*if (response.isSuccess()) {
                        Toast.makeText(getActivity().getBaseContext(), "PASO", Toast.LENGTH_LONG).show();
                        //alFinalizar(response.body());
                    } else {
                        Toast.makeText(getActivity().getBaseContext(), response.errorBody().toString(), Toast.LENGTH_LONG).show();

                    }*/
                }

                @Override
                public void onFailure(Throwable t) {
                    Toast.makeText(getActivity().getBaseContext(), "FALLO", Toast.LENGTH_LONG).show();
                }
            });
        }

        this.adaptador = new SuperAdapter();
        this.adaptador.setOnItemClickListener(this);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(this.adaptador);
        return view;
    }

    @Override
    public void onItemClick(SuperHeroe element) {
        Intent i = new Intent(getActivity(), DetailsActivity.class);
        i.putExtra(INFO_SUPER, element);
        startActivity(i);
    }

    public void addNew(SuperHeroe s) {
        this.adaptador.addNew(s);
    }
}
