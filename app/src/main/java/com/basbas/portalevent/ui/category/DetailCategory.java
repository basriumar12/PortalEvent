package com.basbas.portalevent.ui.category;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.basbas.portalevent.R;

public class DetailCategory extends AppCompatActivity {
    TextView tvTittle,tvHarga,tvDetail;
    ImageView imageView;
    Button btnOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_category);

        tvTittle = findViewById(R.id.tv_title);
        tvHarga = findViewById(R.id.tv_harga);
        tvDetail = findViewById(R.id.tv_detail);
        imageView = findViewById(R.id.image_view);
        btnOrder = findViewById(R.id.btn_order);

    }
}
