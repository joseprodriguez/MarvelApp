package edu.galileo.android.marvelapp.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.galileo.android.marvelapp.R;
import edu.galileo.android.marvelapp.adapter.OnItemClickListener;
import edu.galileo.android.marvelapp.utilities.SuperInfo;

/**
 * Created by José P. Rodríguez on 1/03/2016.
 */
public class PrincipalFragment extends Fragment {
    @Bind(R.id.inputSuper) EditText inputSuper;
    @Bind(R.id.description) TextView description;
    @Bind(R.id.titleSuper) TextView nombre;
    @Bind(R.id.imagen) ImageView imagen;

    private final static String TAG = "FragmentoPrincipal";

    private SuperInfo personaje;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_super_actual, container, false);
        ButterKnife.bind(this, view);

        this.personaje = new SuperInfo("Capitán América", "04n", "ajsfñasjfñasjfñalfjasklfasñfañlkfafñafkasfñajñfda");
        return view;
    }

    @OnClick(R.id.btnSelect)
    public void click(){
        String per = inputSuper.getText().toString();
        //Log.e(TAG, per);
        this.actualizarDatos();
    }

    public void setDatos(SuperInfo s) {
        this.personaje = s;
    }

    public void actualizarDatos() {
        this.nombre.setText(this.personaje.getName());
        this.description.setText(this.personaje.getDescription());
        String strIcono = this.personaje.getImg();
        String iconUrl = "http://openweathermap.org/img/w/" + strIcono + ".png";
        //Log.e(TAG, iconUrl);
        Glide.with(this).load(iconUrl).into(this.imagen);
    }

}
