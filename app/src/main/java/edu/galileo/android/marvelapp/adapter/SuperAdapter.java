package edu.galileo.android.marvelapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import edu.galileo.android.marvelapp.R;
import edu.galileo.android.marvelapp.utilities.connection.SuperHeroe;

/**
 * Created by José P. Rodríguez on 1/03/2016.
 */
public class SuperAdapter extends RecyclerView.Adapter<SuperAdapter.ViewHolder> {
    private List<SuperHeroe> datos;
    private OnItemClickListener clickListener;

    public SuperAdapter() {
        this.datos = new ArrayList<SuperHeroe>();
    }

    public void setOnItemClickListener(OnItemClickListener clickListener){
        this.clickListener = clickListener;
    }

    public void addNew(SuperHeroe s) {
        this.datos.add(s);
    }

    @Override
    public SuperAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_super, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        SuperHeroe element = this.datos.get(position);
        holder.contenido.setText(element.getName());
        if (this.clickListener != null) {
            holder.setOnItemClickListener(element, this.clickListener);
        }
    }

    @Override
    public int getItemCount() {
        return this.datos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private View vista;
        public TextView contenido;

        public ViewHolder(View v) {
            super(v);
            this.vista = v;
            this.contenido = (TextView)v.findViewById(R.id.txtContent);
        }

        public void setOnItemClickListener(final SuperHeroe element,
                                           final OnItemClickListener listener){
            this.vista.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    listener.onItemClick(element);
                }
            });
        }
    }
}
