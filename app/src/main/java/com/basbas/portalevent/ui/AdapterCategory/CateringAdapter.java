package com.basbas.portalevent.ui.AdapterCategory;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.basbas.portalevent.R;
import com.basbas.portalevent.model.ResponseCatering;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CateringAdapter extends RecyclerView.Adapter<CateringAdapter.viewHolder> {
   Context context;
   List<ResponseCatering> responseCaterings;

    public CateringAdapter(Context context, List<ResponseCatering> responseCaterings) {
        this.context = context;
        this.responseCaterings = responseCaterings;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_catering,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        ResponseCatering responseCatering = responseCaterings.get(position);

        holder.tv_idLapak.setText(responseCatering.getId_lapak());
        holder.tv_idJenis.setText(responseCatering.getId_jenis());
        holder.tv_idMitra.setText(responseCatering.getId_mitra());
        holder.tv_namapelapak.setText(responseCatering.getNama_lapak());
        holder.tv_harga.setText(responseCatering.getHarga());
        holder.tv_ketersediaan.setText(responseCatering.getKetersediaan());
        holder.tv_detail.setText(responseCatering.getDetail());

        //Picasso.with()
    }

    @Override
    public int getItemCount() {
        return responseCaterings.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        TextView tv_idLapak,tv_idMitra,tv_namapelapak,tv_idJenis,tv_detail,tv_ketersediaan,tv_harga;
        ImageView fotocategory;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            tv_idLapak = itemView.findViewById(R.id.id_lapak);
            tv_idMitra = itemView.findViewById(R.id.id_mitra);
            tv_namapelapak = itemView.findViewById(R.id.nama_pelapak);
            tv_idJenis = itemView.findViewById(R.id.id_jenis);
            tv_detail = itemView.findViewById(R.id.detail);
            tv_ketersediaan = itemView.findViewById(R.id.ketersediaan);
            tv_harga = itemView.findViewById(R.id.harga);
            fotocategory = itemView.findViewById(R.id.foto_category);
        }
    }
}
