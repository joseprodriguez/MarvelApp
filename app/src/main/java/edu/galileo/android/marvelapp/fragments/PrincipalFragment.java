package edu.galileo.android.marvelapp.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;


import butterknife.Bind;
import butterknife.ButterKnife;
import edu.galileo.android.marvelapp.R;
import edu.galileo.android.marvelapp.utilities.connection.SuperHeroe;

/**
 * Created by José P. Rodríguez on 1/03/2016.
 */
public class PrincipalFragment extends Fragment {
    @Bind(R.id.description) TextView description;
    @Bind(R.id.titleSuper) TextView nombre;
    @Bind(R.id.imagen) ImageView imagen;

    private final static String TAG = "FragmentoPrincipal";

    private SuperHeroe personaje;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_super_actual, container, false);
        ButterKnife.bind(this, view);

        this.personaje = new SuperHeroe("Marvel", "04n");
        return view;
    }

    public void setDatos(SuperHeroe s) {
        this.personaje = s;
    }

    public void actualizarDatos() {
        this.nombre.setText(this.personaje.getName());
        this.description.setText(this.personaje.getDescription());
        String strIcono = this.personaje.getImagePath();
        Glide.with(this).load(strIcono).into(this.imagen);
    }

}
