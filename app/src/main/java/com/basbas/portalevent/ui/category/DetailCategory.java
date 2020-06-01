package com.basbas.portalevent.ui.category;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.basbas.portalevent.R;
import com.basbas.portalevent.utils.Constant;
import com.squareup.picasso.Picasso;

public class DetailCategory extends AppCompatActivity {
    TextView tvTittle,tvHarga,tvDetail;
    ImageView imageView;
    Button btnOrder;

    String tittle,detail,harga,gambar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_category);

        tvTittle = findViewById(R.id.tv_title);
        tvHarga = findViewById(R.id.tv_harga);
        tvDetail = findViewById(R.id.tv_detail);
        imageView = findViewById(R.id.image_view);
        btnOrder = findViewById(R.id.btn_order);

        tittle = getIntent().getStringExtra("title");
        harga = getIntent().getStringExtra("harga");
        detail = getIntent().getStringExtra("detail");
        gambar = getIntent().getStringExtra("gambar");
        Picasso.get().load(Constant.BASEURLIMAGE+gambar).
                error(R.mipmap.ic_launcher).into(imageView);

        tvTittle.setText(tittle);
        tvHarga.setText(harga);
        tvDetail.setText(detail);
    }
}
