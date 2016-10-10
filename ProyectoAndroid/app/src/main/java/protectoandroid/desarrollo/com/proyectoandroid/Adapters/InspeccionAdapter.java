package protectoandroid.desarrollo.com.proyectoandroid.Adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import protectoandroid.desarrollo.com.proyectoandroid.Activities.InspectionActivity;
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

    private Context mContext;
    private List<Inspeccion> list;

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        public TextView cantidadMuestra, nroInspect, fecha, lugar;
        public ImageView cover;
        public CardView cardView;

        public CustomViewHolder(View view) {
            super(view);
            cardView = (CardView) view.findViewById(R.id.inspeccionCard);
            cantidadMuestra = (TextView) view.findViewById(R.id.cantidadMuestraTextView);
            cover = (ImageView) view.findViewById(R.id.coverImageViewInspeccion);
            nroInspect = (TextView) view.findViewById(R.id.nroInspectTextView);
            fecha = (TextView) view.findViewById(R.id.fechaTextView);
            lugar = (TextView) view.findViewById(R.id.lugarTextView);
        }
    }

    public InspeccionAdapter(Context mContext, List<Inspeccion> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @Override
    public InspeccionAdapter.CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.inspeccion_card, parent, false);

        return new InspeccionAdapter.CustomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(InspeccionAdapter.CustomViewHolder holder, final int position) {
        Inspeccion inspeccion = list.get(position);
        holder.cantidadMuestra.setText(Integer.toString(inspeccion.getCantidadMuestra()));
        holder.nroInspect.setText(inspeccion.getNroInspect()== null ? "" : inspeccion.getNroInspect());
        holder.fecha.setText(inspeccion.getFecha() == null ? "" : inspeccion.getFecha() );
        holder.lugar.setText(inspeccion.getLugar()== null ? "" : inspeccion.getLugar());
        //holder.cover.setImageDrawable(Integer.parseInt(R.drawable.inspeccion_image));
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* Intent itemIntent = new Intent(view.getContext(), InspectionActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("id", list.get(position).getId());
                bundle.putString("cliente", list.get(position).getCliente());
                bundle.putString("nroOrden", list.get(position).getNroOrden());
                itemIntent.putExtras(bundle);
                view.getContext().startActivity(itemIntent);*/
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

