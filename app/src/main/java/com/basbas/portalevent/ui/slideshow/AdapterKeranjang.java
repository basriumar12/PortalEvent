package com.basbas.portalevent.ui.slideshow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.basbas.portalevent.R;
import com.basbas.portalevent.model.ResponseKeranjang;
import com.basbas.portalevent.ui.category.AdapterCategories;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Callback;

public class AdapterKeranjang extends RecyclerView.Adapter<AdapterKeranjang.MyHolder> {
    Context context;
    List<ResponseKeranjang> keranjang;

    public AdapterKeranjang(Context con, List<ResponseKeranjang> data) {
        this.context = con;
        this.keranjang = data;
    }

    @NonNull
    @Override
    public AdapterKeranjang.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_keranjang,parent,false);
       MyHolder holder = new MyHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.tv_Keterangan.setText(keranjang.get(position).getKet_lapak());
        holder.tv_jumlah.setText(keranjang.get(position).getJml());
        holder.tv_Tanggalpakai.setText(keranjang.get(position).getTgl_pakai());
        holder.tv_TampilKeranjang.setText(keranjang.get(position).getTampil_keranjang());
    }

    @Override
    public int getItemCount() {
        return keranjang.size();
    }


    public class MyHolder extends RecyclerView.ViewHolder {
        TextView tv_Keterangan,tv_Tanggalpakai,tv_jumlah,tv_TampilKeranjang;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            tv_Keterangan = itemView.findViewById(R.id.tv_ketlapak);
            tv_TampilKeranjang = itemView.findViewById(R.id.tv_tampil_keranjang);
            tv_jumlah = itemView.findViewById(R.id.tv_jml);
            tv_Tanggalpakai = itemView.findViewById(R.id.tv_tgl_pakai);
        }
    }
}
