package edu.galileo.android.marvelapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import edu.galileo.android.marvelapp.R;
import edu.galileo.android.marvelapp.utilities.SuperInfo;

/**
 * Created by José P. Rodríguez on 1/03/2016.
 */
public class SuperAdapter extends RecyclerView.Adapter<SuperAdapter.ViewHolder> {
    private SuperInfo[] datos;
    private OnItemClickListener clickListener;

    public SuperAdapter(SuperInfo[] data) {
        this.datos = data;
    }

    public void setOnItemClickListener(OnItemClickListener clickListener){
        this.clickListener = clickListener;
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
        SuperInfo element = this.datos[position];
        holder.contenido.setText(element.getName());
        if (this.clickListener != null) {
            holder.setOnItemClickListener(element, this.clickListener);
        }
    }

    @Override
    public int getItemCount() {
        return this.datos.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private View vista;
        public TextView contenido;

        public ViewHolder(View v) {
            super(v);
            this.vista = v;
            this.contenido = (TextView)v.findViewById(R.id.txtContent);
        }

        public void setOnItemClickListener(final SuperInfo element,
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
