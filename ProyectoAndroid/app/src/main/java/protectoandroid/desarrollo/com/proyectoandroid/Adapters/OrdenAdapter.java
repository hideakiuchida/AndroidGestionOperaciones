package protectoandroid.desarrollo.com.proyectoandroid.Adapters;

import android.content.Context;
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
public class OrdenAdapter extends RecyclerView.Adapter<OrdenAdapter.CustomViewHolder>{

    private Context mContext;
    private List<Orden> list;

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        public TextView descripcion, cliente, latitud, longitud;

        public CustomViewHolder(View view) {
            super(view);
            descripcion = (TextView) view.findViewById(R.id.descripcion);
            cliente = (TextView) view.findViewById(R.id.cliente);
            latitud = (TextView) view.findViewById(R.id.latitud);
            longitud = (TextView) view.findViewById(R.id.longitud);
        }
    }

    public OrdenAdapter(Context mContext, List<Orden> ordenList) {
        this.mContext = mContext;
        this.list = ordenList;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.orden_row_list, parent, false);

        return new CustomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        Orden orden = list.get(position);
        holder.descripcion.setText(orden.getDescripcion());
        holder.cliente.setText(orden.getCliente());
        holder.latitud.setText(orden.getLatitud());
        holder.longitud.setText(orden.getLongitud());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

