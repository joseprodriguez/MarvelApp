package edu.galileo.android.marvelapp.fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.galileo.android.marvelapp.R;
import edu.galileo.android.marvelapp.activities.DetailsActivity;
import edu.galileo.android.marvelapp.adapter.OnItemClickListener;
import edu.galileo.android.marvelapp.adapter.SuperAdapter;
import edu.galileo.android.marvelapp.utilities.SuperInfo;

/**
 * Created by José P. Rodríguez on 1/03/2016.
 */
public class ListFragment extends Fragment implements OnItemClickListener {
    private RecyclerView recyclerView;
    private SuperAdapter adaptador;
    private final static String TAG = "FragmentoLista";
    public final static String INFO_SUPER = "informacion_del_personaje";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        SuperInfo datos[] = new SuperInfo[3];
        datos[0] = new SuperInfo("Capitan America", "04n", "primero");
        datos[1] = new SuperInfo("Capitan America2", "03n", "segundo");
        datos[2] = new SuperInfo("Capitan America3", "02n", "tercero");

        this.adaptador = new SuperAdapter(datos);
        this.adaptador.setOnItemClickListener(this);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(this.adaptador);
        return view;
    }

    @Override
    public void onItemClick(SuperInfo element) {
        /*PrincipalFragment fragment = (PrincipalFragment) getFragmentManager().findFragmentById(R.id.fragPrinc);
        fragment.setDatos(element);
        fragment.actualizarDatos();*/

        Intent i = new Intent(getActivity(), DetailsActivity.class);
        i.putExtra(INFO_SUPER, element);
        startActivity(i);
    }
}
