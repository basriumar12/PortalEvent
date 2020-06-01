package com.basbas.portalevent.ui.category;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.basbas.portalevent.R;
import com.basbas.portalevent.model.ResponseCategories;
import com.basbas.portalevent.utils.Constant;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterCategories extends RecyclerView.Adapter<AdapterCategories.MyHolder>  {

    Context con;
    List<ResponseCategories> data;
    //buat constructor dari variabel diatas
    public AdapterCategories(Context con, List<ResponseCategories> data) {
        this.con = con;
        this.data = data;
    }
    @Override
    public AdapterCategories.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_view_categories,parent,false);
        MyHolder holder = new MyHolder(v);

        //
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterCategories.MyHolder holder, final int position) {

        holder.tvTitle.setText(data.get(position).getNama_lapak());
        holder.tvPrice.setText("RP."+data.get(position).getHarga());
        String url = Constant.BASEURLIMAGE +data.get(position).getUrl_foto();
        if (data.get(position).getUrl_foto().isEmpty()){
            holder.imgCategories.setImageResource(R.drawable.ic_launcher_foreground);
        } else {

            Picasso.get().load(url).error(R.drawable.ic_launcher_background).into(holder.imgCategories);
        }
        holder.tvDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(con,DetailCategory.class);
               intent.putExtra("title",data.get(position).getNama_lapak());
               intent.putExtra("harga",data.get(position).getHarga());
               intent.putExtra("detail",data.get(position).getDetail());
               intent.putExtra("gambar",data.get(position).getUrl_foto());

               con.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        ImageView imgCategories ;
        TextView tvTitle, tvPrice, tvDetail;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            imgCategories = itemView.findViewById(R.id.img_categories);
            tvDetail = itemView.findViewById(R.id.tv_detail_categories);
            tvPrice = itemView.findViewById(R.id.tv_price_categories);
            tvTitle = itemView.findViewById(R.id.tv_title_categories);
        }
    }
}
