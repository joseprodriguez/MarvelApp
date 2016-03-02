package edu.galileo.android.marvelapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import edu.galileo.android.marvelapp.R;
import edu.galileo.android.marvelapp.fragments.ListFragment;
import edu.galileo.android.marvelapp.fragments.PrincipalFragment;
import edu.galileo.android.marvelapp.utilities.SuperInfo;

/**
 * Created by José P. Rodríguez on 1/03/2016.
 */
public class DetailsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Intent i = getIntent();
        SuperInfo data = (SuperInfo)i.getSerializableExtra(ListFragment.INFO_SUPER);
        PrincipalFragment fragment = (PrincipalFragment)getFragmentManager().findFragmentById(R.id.fragPrinc);
        fragment.setDatos(data);
        fragment.actualizarDatos();
    }
}
