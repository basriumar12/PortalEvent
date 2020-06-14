package com.basbas.portalevent.ui.category;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.basbas.portalevent.R;
import com.basbas.portalevent.model.ResponseData;
import com.basbas.portalevent.network.RestApi;
import com.basbas.portalevent.network.RetroServer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TambahKeranjangActivity extends AppCompatActivity {
    EditText edtTangal,edtJumlah,edtKeterangan,idPembeli,idLapak,edtTampilkeranjang;
    Button btnCheckout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_keranjang);
        init();
        addKeranjang();
    }

    private void addKeranjang() {
        RestApi api = RetroServer.getClient().create(RestApi.class);
        btnCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tIdlapak = idLapak.getText().toString();
                String tIdpembeli = idPembeli.getText().toString();
                String tTanggal = edtTangal.getText().toString();
                String tKeterangan = edtKeterangan.getText().toString();
                String tJumlah = edtJumlah.getText().toString();
                String tTampilKeranjang = edtTampilkeranjang.getText().toString();
                    if(tIdlapak.isEmpty()|tIdpembeli.isEmpty()|tTampilKeranjang.isEmpty()|tTanggal.isEmpty() | tKeterangan.isEmpty() | tJumlah.isEmpty()){
                        Toast.makeText(TambahKeranjangActivity.this, "Jangan Dikosongin!", Toast.LENGTH_SHORT).show();
                    }else {
                        RestApi api = RetroServer.getClient().create(RestApi.class);
                        Call<ResponseData> respon = api.postKeranjang(tIdlapak,tIdpembeli,tTanggal,tKeterangan,tJumlah,tTampilKeranjang);
                        respon.enqueue(new Callback<ResponseData>() {
                            @Override
                            public void onResponse(Call<ResponseData> call, Response<ResponseData> response) {
                                int kode = response.body().getKode();
                                if(kode == 1){
                                    Toast.makeText(TambahKeranjangActivity.this, "Berhasil menambahkan data form", Toast.LENGTH_SHORT).show();
                                }else {
                                    Toast.makeText(TambahKeranjangActivity.this, "Gagal menambahkan data form", Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<ResponseData> call, Throwable t) {
                                Toast.makeText(TambahKeranjangActivity.this, "gagal", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
            }
        });
    }

    private void init() {
    edtTangal = findViewById(R.id.edt_tanggalPakai);
    edtJumlah = findViewById(R.id.edt_jumlah);
    edtKeterangan = findViewById(R.id.edt_keterangan);
    btnCheckout = findViewById(R.id.btn_TampilKeranjang);
    idLapak = findViewById(R.id.idlapak);
    idPembeli = findViewById(R.id.idpembeli);
    edtTampilkeranjang = findViewById(R.id.edt_tampilkeranjang);
    }
}
