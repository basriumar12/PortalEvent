package com.basbas.portalevent.ui.keranjang;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.basbas.portalevent.R;
import com.basbas.portalevent.model.ResponseKeranjang;
import com.basbas.portalevent.ui.keranjang.model.DataKeranjang;
import com.basbas.portalevent.utils.Constant;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterKeranjang extends RecyclerView.Adapter<AdapterKeranjang.MyHolder> {
    Context context;
    List<DataKeranjang> keranjang;

    public AdapterKeranjang(Context con, List<DataKeranjang> data) {
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
        holder.tv_nama.setText(keranjang.get(position).getNama_lapak());
        holder.tv_Keterangan.setText("Ket : "+keranjang.get(position).getKeterangan());
        holder.tv_jumlah.setText("Jumlah : "+keranjang.get(position).getJml());
        holder.tv_Tanggalpakai.setText("Tgl : "+keranjang.get(position).getTgl());
        holder.tv_hargaKeranjang.setText("Harga : Rp"+keranjang.get(position).getHarga());
        String url = Constant.BASEURLIMAGE +keranjang.get(position).getFoto();
        if (keranjang.get(position).getFoto().isEmpty()){
            holder.imgKeranjang.setImageResource(R.drawable.ic_launcher_foreground);
        } else {
            Picasso.get().load(url).error(R.drawable.ic_launcher_background).into(holder.imgKeranjang);
        }
    }

    @Override
    public int getItemCount() {
        return keranjang.size();
    }


    public class MyHolder extends RecyclerView.ViewHolder {
        TextView tv_Keterangan,tv_Tanggalpakai,tv_jumlah,tv_hargaKeranjang, tv_nama;
        ImageView imgKeranjang;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            imgKeranjang = itemView.findViewById(R.id.img_keranjang);
            tv_Keterangan = itemView.findViewById(R.id.tv_ketlapak);
            tv_hargaKeranjang = itemView.findViewById(R.id.tv_harga_keranjang);
            tv_jumlah = itemView.findViewById(R.id.tv_jumlah);
            tv_nama = itemView.findViewById(R.id.tv_nama);
            tv_Tanggalpakai = itemView.findViewById(R.id.tv_tgl_pakai);
        }
    }
}
