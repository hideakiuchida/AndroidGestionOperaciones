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
import protectoandroid.desarrollo.com.proyectoandroid.Model.Orden;
import protectoandroid.desarrollo.com.proyectoandroid.R;

/**
 * Created by ArkMetal on 20/09/2016.
 */
public class OrdenAdapter extends RecyclerView.Adapter<OrdenAdapter.CustomViewHolder>{

    private Context mContext;
    private List<Orden> list;

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        public TextView descripcion, nroOrden;
        public ImageView cover;
        public CardView cardView;

        public CustomViewHolder(View view) {
            super(view);
            cardView = (CardView) view.findViewById(R.id.ordenCard);
            descripcion = (TextView) view.findViewById(R.id.titleOrdenTextView);
            cover = (ImageView) view.findViewById(R.id.coverImageView);
            nroOrden = (TextView) view.findViewById(R.id.nroOrdenTextView);
        }
    }

    public OrdenAdapter(Context mContext, List<Orden> ordenList) {
        this.mContext = mContext;
        this.list = ordenList;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.orden_card, parent, false);

        return new CustomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, final int position) {
        Orden orden = list.get(position);
        holder.descripcion.setText(orden.getDescripcion());
        //holder.cover.setImageDrawable(Integer.parseInt(R.drawable.inspeccion_image));
        holder.nroOrden.setText(orden.getNroOrden());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent itemIntent = new Intent(view.getContext(), InspectionActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("id", list.get(position).getId());
                bundle.putString("cliente", list.get(position).getCliente());
                bundle.putString("nroOrden", list.get(position).getNroOrden());
                itemIntent.putExtras(bundle);
                view.getContext().startActivity(itemIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

