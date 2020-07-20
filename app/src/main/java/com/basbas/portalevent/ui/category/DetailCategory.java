package com.basbas.portalevent.ui.category;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.basbas.portalevent.R;
import com.basbas.portalevent.model.ResponseData;
import com.basbas.portalevent.network.RestApi;
import com.basbas.portalevent.network.RetroServer;
import com.basbas.portalevent.pref.SessionPref;
import com.basbas.portalevent.utils.Constant;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailCategory extends AppCompatActivity {
    TextView tvTittle, tvHarga, tvDetail, tvTanggal;
    ImageView imageView;
    Button btnOrder;
    private DatePickerDialog datePickerDialog;
    private SimpleDateFormat dateFormatter;
    String tittle, detail, harga, gambar, idlapak;
    String tanggal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_category);
        getSupportActionBar().setTitle(getString(R.string.detail_categories));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tvTittle = findViewById(R.id.tv_title);
        tvHarga = findViewById(R.id.tv_harga);
        tvDetail = findViewById(R.id.tv_detail);
        imageView = findViewById(R.id.image_view);
        btnOrder = findViewById(R.id.btn_order);

        tittle = getIntent().getStringExtra("title");
        harga = getIntent().getStringExtra("harga");
        detail = getIntent().getStringExtra("detail");
        gambar = getIntent().getStringExtra("gambar");
        idlapak = getIntent().getStringExtra("idlapak");
        Picasso.get().load(Constant.BASEURLIMAGE + gambar).
                error(R.mipmap.ic_launcher).into(imageView);

        tvTittle.setText(tittle);
        tvHarga.setText(harga);
        tvDetail.setText(detail);
        dateFormatter = new SimpleDateFormat("yyyy-dd-mm", Locale.US);

        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View dialogView = getLayoutInflater().inflate(R.layout.view_bottom_order, null);
                BottomSheetDialog dialog = new BottomSheetDialog(DetailCategory.this);
                dialog.setContentView(dialogView);
                Button btnOrder = dialogView.findViewById(R.id.btn_order_now);
                final ProgressBar pb = dialogView.findViewById(R.id.progggress_circular_bottom);
                tvTanggal = dialogView.findViewById(R.id.tv_pilih_tanggal);
                final EditText edtKeterangan = dialogView.findViewById(R.id.edt_keterangan);
                tvTanggal.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showDateDialog();

                    }
                });
                btnOrder.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (edtKeterangan.getText().toString().isEmpty()) {
                            Toast.makeText(DetailCategory.this, "Keterangan tidak bisa kosong", Toast.LENGTH_SHORT).show();
                        } else if (tvTanggal.getText().toString().endsWith("Pilih Tanggal")) {
                            Toast.makeText(DetailCategory.this, "Tanggal belum dipilih", Toast.LENGTH_SHORT).show();

                        } else {
                            pb.setVisibility(View.VISIBLE);
                            String idPembeli = new SessionPref(DetailCategory.this).getID();
                            RestApi api = RetroServer.getClient().create(RestApi.class);
                            Call<ResponseData> respon = api.postKeranjang(idPembeli, idlapak, tanggal, edtKeterangan.getText().toString(), "1", "Y");
                            respon.enqueue(new Callback<ResponseData>() {
                                @Override
                                public void onResponse(Call<ResponseData> call, Response<ResponseData> response) {
                                    int kode = response.body().getKode();
                                    if (kode == 1) {
                                        pb.setVisibility(View.GONE);
                                        Toast.makeText(DetailCategory.this, "Berhasil menambahkan data", Toast.LENGTH_SHORT).show();
                                        finish();
                                    } else {
                                        pb.setVisibility(View.GONE);
                                        Toast.makeText(DetailCategory.this, "Gagal menambahkan data", Toast.LENGTH_SHORT).show();
                                    }
                                }

                                @Override
                                public void onFailure(Call<ResponseData> call, Throwable t) {
                                    pb.setVisibility(View.GONE);
                                    Toast.makeText(DetailCategory.this, "Gagal menambahkan data", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }


                    }
                });

                dialog.show();
            }


        });


    }

    private void showDateDialog() {


        Calendar newCalendar = Calendar.getInstance();
        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            final Calendar newDate = Calendar.getInstance();

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                tvTanggal.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                String tgl = year +"-"+(monthOfYear+1)+"-"+dayOfMonth+" 12:12:12";
                tanggal = tgl;
                Log.e("TAG","tgl "+tgl);


            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();

    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
