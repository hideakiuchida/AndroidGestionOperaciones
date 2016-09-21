package protectoandroid.desarrollo.com.proyectoandroid.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import protectoandroid.desarrollo.com.proyectoandroid.Model.Inspeccion;
import protectoandroid.desarrollo.com.proyectoandroid.Model.Orden;
import protectoandroid.desarrollo.com.proyectoandroid.R;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import protectoandroid.desarrollo.com.proyectoandroid.Model.Orden;
import protectoandroid.desarrollo.com.proyectoandroid.R;

/**
 * Created by ArkMetal on 20/09/2016.
 */
public class InspeccionAdapter extends RecyclerView.Adapter<InspeccionAdapter.CustomViewHolder>{

    private List<Inspeccion> list;

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        public TextView nroorden, fecha, cantidadMuestra, lugar;

        public CustomViewHolder(View view) {
            super(view);
            nroorden = (TextView) view.findViewById(R.id.nroorden);
            fecha = (TextView) view.findViewById(R.id.fecha);
            cantidadMuestra = (TextView) view.findViewById(R.id.cantidadMuestra);
            lugar = (TextView) view.findViewById(R.id.lugar);
        }
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.inspeccion_row_list, parent, false);

        return new CustomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        Inspeccion inspeccion = list.get(position);
        holder.nroorden.setText(inspeccion.getNroOrden());
        holder.fecha.setText(inspeccion.getFecha());
        holder.cantidadMuestra.setText(inspeccion.getCantidadMuestra());
        holder.lugar.setText(inspeccion.getLugar());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

