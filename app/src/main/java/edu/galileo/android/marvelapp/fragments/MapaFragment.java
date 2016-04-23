package edu.galileo.android.marvelapp.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.galileo.android.marvelapp.R;

/**
 * Created by José P. Rodríguez on 18/04/2016.
 */
public class MapaFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mapa, container, false);
        return view;
    }

}
