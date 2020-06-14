package com.basbas.portalevent.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.basbas.portalevent.R;
import com.basbas.portalevent.model.ResponseData;
import com.basbas.portalevent.network.RestApi;
import com.basbas.portalevent.network.RetroServer;
import com.basbas.portalevent.pref.SessionPref;
import com.basbas.portalevent.ui.main.MainActivity;
import com.basbas.portalevent.ui.register.RegisterActivity;
import com.basbas.portalevent.utils.MyFunction;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//setiap activity yang dibuat, di extends ke MyFunction
//supya bisa mendapatkan method pesan dan accseskelas
public class LoginActivity extends MyFunction {
    TextView edtUsername, edtPassword;
    Button btn_Login;
    TextView tvGoToegister;
    SessionPref sessionPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //untuk inisialisasi id dibuat dalam method initView
        //unutuk action button dibuat dalam method action button
        //dan untuk http koneksi ke server gunakan method baru
        initView();
        actionButton();


    }


    private void actionButton() {
        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginAction();


            }
        });
        tvGoToegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aksesclass(RegisterActivity.class);

            }
        });
    }

    public void loginAction() {
        final String vUsername = edtUsername.getText().toString();
        String vPassword = edtPassword.getText().toString();

        if (vUsername.isEmpty() || vPassword.isEmpty()) {
            pesan("Jangan kosong ya");
        } else {
            btn_Login.setVisibility(View.VISIBLE);
            RestApi api = RetroServer.getClient().create(RestApi.class);
            Call<ResponseData> userLogin = api.userLogin(vUsername, vPassword);
            userLogin.enqueue(new Callback<ResponseData>() {
                @Override
                public void onResponse(Call<ResponseData> call, Response<ResponseData> response) {
                    int kode = response.body().getKode();
                    if (kode == 1) {
                        sessionPref.createLoginSession(vUsername, response.body().getId());
                        aksesclass(MainActivity.class);
                        pesan("Berhasil Login");
                    } else {
                        pesan("Coba Cek Username dan Password lagi");
                    }
                }

                @Override
                public void onFailure(Call<ResponseData> call, Throwable t) {
                    ;
                    pesan("Gagal Login");
                }
            });
        }
    }

    private void initView() {
        sessionPref = new SessionPref(LoginActivity.this);
        sessionPref.checkLogin();
        edtUsername = findViewById(R.id.edt_username);
        edtPassword = findViewById(R.id.edt_password);
        btn_Login = findViewById(R.id.btn_login);
        tvGoToegister = findViewById(R.id.tv_go_to_register);
    }
}
