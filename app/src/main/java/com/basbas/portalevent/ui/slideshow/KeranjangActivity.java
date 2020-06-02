package com.basbas.portalevent.ui.slideshow;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.basbas.portalevent.R;
import com.basbas.portalevent.model.ResponseCategories;
import com.basbas.portalevent.model.ResponseKeranjang;
import com.basbas.portalevent.network.RestApi;
import com.basbas.portalevent.pref.SessionPref;
import com.basbas.portalevent.ui.category.AdapterCategories;
import com.basbas.portalevent.utils.Constant;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class KeranjangActivity extends AppCompatActivity {
//    TextView tv_ketLapak,tv_tglPakai,tv_Jml,tv_Tampilkeranjang;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    List<ResponseKeranjang> data;
    ProgressBar progressBar;
    SessionPref sessionPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keranjang);
//        init();
        progressBar = findViewById(R.id.progres_keranjang);
        recyclerView = findViewById(R.id.rv_keranjang);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setLayoutManager(layoutManager);
        getData();
    }

    private void getData() {
        progressBar.setVisibility(View.VISIBLE);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RestApi api = retrofit.create(RestApi.class);
        Call<ArrayList<ResponseKeranjang>> responseKeranjangCall = api.getKeranjang("Login1590320775");
        responseKeranjangCall.enqueue(new Callback<ArrayList<ResponseKeranjang>>() {
            @Override
            public void onResponse(Call<ArrayList<ResponseKeranjang>> call, Response<ArrayList<ResponseKeranjang>> response) {
//                if(response.isSuccessful()){
//                    progressBar.setVisibility(View.GONE);
//                    ArrayList<ResponseKeranjang> dataResponse = response.body();
//                    AdapterKeranjang adapterKeranjang = new AdapterKeranjang(getBaseContext(),dataResponse);
//                    recyclerView.setAdapter(adapterKeranjang);
//                    adapterKeranjang.notifyDataSetChanged();
//                }else {
//                    progressBar.setVisibility(View.GONE);
//                    Toast.makeText(KeranjangActivity.this, "Data Kosong", Toast.LENGTH_SHORT).show();
//                }

                Log.e("TAG","data berhasil "+new Gson().toJson(response.body()));
            }

            @Override
            public void onFailure(Call<ArrayList<ResponseKeranjang>> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(KeranjangActivity.this, "Data Kosong", Toast.LENGTH_SHORT).show();
            }
        });
    }

//    private void init() {
//        tv_ketLapak = findViewById(R.id.tv_ketlapak);
//        tv_tglPakai = findViewById(R.id.tv_tgl_pakai);
//        tv_Jml = findViewById(R.id.tv_jml);
//        tv_Tampilkeranjang = findViewById(R.id.tv_tampil_keranjang);
//    }
}
