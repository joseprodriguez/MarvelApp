package edu.galileo.android.marvelapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.galileo.android.marvelapp.R;
import edu.galileo.android.marvelapp.utilities.SuperInfo;

public class MainActivity extends AppCompatActivity {
    private final static String TAG = "MainActivity";
    @Bind(R.id.inputSuper) EditText inputSuper;
    @Bind(R.id.description) TextView description;
    @Bind(R.id.titleSuper) TextView nombre;
    @Bind(R.id.imagen) ImageView imagen;

    private SuperInfo personaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Log.e(TAG, "se creo");

        this.personaje = new SuperInfo("Capitán América", "04n", "ajsfñasjfñasjfñalfjasklfasñfañlkfafñafkasfñajñfda");
    }

    @OnClick(R.id.btnSelect)
    public void click(){
        String per = inputSuper.getText().toString();
        Log.e(TAG, per);
        nombre.setText(this.personaje.getName());
        description.setText(this.personaje.getDescription());
        String strIcono = this.personaje.getImg();
        String iconUrl = "http://openweathermap.org/img/w/" + strIcono + ".png";
        Log.e(TAG, iconUrl);
        Glide.with(this).load(iconUrl).into(imagen);
    }
}
