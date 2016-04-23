package edu.galileo.android.marvelapp.fragments;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.galileo.android.marvelapp.R;
import edu.galileo.android.marvelapp.utilities.connection.ConexionAPI;
import edu.galileo.android.marvelapp.utilities.connection.Hashing;
import edu.galileo.android.marvelapp.utilities.connection.Request;
import edu.galileo.android.marvelapp.utilities.connection.SuperHeroe;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by José P. Rodríguez on 17/04/2016.
 */
public class EntireFragment extends Fragment {
    private final static String TAG = "EntireFragment";
    @Bind(R.id.inputSuper) EditText inputSuper;
    @Bind(R.id.description)TextView description;
    @Bind(R.id.titleSuper) TextView nombre;
    @Bind(R.id.imagen) ImageView imagen;

    private SuperHeroe personaje;
    private ProgressDialog progressDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_main, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @OnClick(R.id.btnSelect)
    public void click(){
        final String per = inputSuper.getText().toString();
        final ListFragment f = (ListFragment) getActivity().getFragmentManager().findFragmentById(R.id.fragList1);
        Hashing h = ConexionAPI.getHash();
        Call<Request> requestResultCall = ConexionAPI.service.charByName(per, h.getTs(), h.getHashcode(), ConexionAPI.PUBLIC_KEY);
        progressDialog = ProgressDialog.show(getActivity(), "", "Buscando: " + per + "... espere", true);
        requestResultCall.enqueue(new Callback<Request>() {

            @Override
            public void onResponse(Response<Request> response, Retrofit retrofit) {
                int c = response.body().getData().getCount();
                if (c == 0) {
                    Toast.makeText(getActivity().getBaseContext(), "No se encontró: " + per, Toast.LENGTH_LONG).show();
                } else {
                    change(response.body().getData().getResults().get(0));
                }
                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(getActivity().getBaseContext(), "FALLO", Toast.LENGTH_LONG).show();
                progressDialog.dismiss();
            }
        });
    }

    public void change(SuperHeroe s) {
        this.personaje = s;
        nombre.setText(this.personaje.getName());
        description.setText(this.personaje.getDescription());
        String strIcono = this.personaje.getImagePath();
        Glide.with(this).load(strIcono).into(imagen);
    }
}
