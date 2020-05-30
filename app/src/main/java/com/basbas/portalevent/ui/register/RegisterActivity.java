package com.basbas.portalevent.ui.register;

import androidx.annotation.NonNull;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.basbas.portalevent.R;
import com.basbas.portalevent.ui.login.LoginActivity;
import com.basbas.portalevent.model.ResponseData;
import com.basbas.portalevent.network.RestApi;
import com.basbas.portalevent.network.RetroServer;
import com.basbas.portalevent.utils.MyFunction;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RegisterActivity extends MyFunction {

    EditText nama,username,password,email,notlf;
    Button btnregis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        getSupportActionBar().setTitle(getString(R.string.register));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nama = findViewById(R.id.edt_name);
        username = findViewById(R.id.edt_username);
        password = findViewById(R.id.edt_password);
        email = findViewById(R.id.edt_email);
        notlf = findViewById(R.id.edt_notelpon);
        btnregis = findViewById(R.id.btn_register);
        registerAccount();
    }

    private void registerAccount() {
        RestApi api = RetroServer.getClient().create(RestApi.class);
        btnregis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String vNama = nama.getText().toString();
                String vUsername = username.getText().toString();
                String vPassword = password.getText().toString();
                String vEmail = email.getText().toString();
                String vNotlf = notlf.getText().toString();
                if(vNama.isEmpty()||
                        vUsername.isEmpty()||
                        vPassword.isEmpty()||
                        vEmail.isEmpty()||
                        vNotlf.isEmpty()){
                    pesan("Jangan kosong ya");
                }else{
                    RestApi api = RetroServer.getClient().create(RestApi.class);
                    Call<ResponseData> userRegis = api.userRegister(vNama,vUsername,vPassword,vEmail,vNotlf);
                    userRegis.enqueue(new Callback<ResponseData>() {
                    @Override
                    public void onResponse(Call<ResponseData> call, Response<ResponseData> response) {
                        int kode = response.body().getKode();
                        if(kode == 1){
                            pesan("Berhasil Register");
                            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                        }else {
                            pesan("Gagal Register");
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseData> call, Throwable t) {
                        pesan("GAGAL,ULANG AJA");
                    }
                });
                }
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
