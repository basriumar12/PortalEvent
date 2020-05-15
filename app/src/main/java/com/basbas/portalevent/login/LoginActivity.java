package com.basbas.portalevent.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.basbas.portalevent.R;
import com.basbas.portalevent.network.RestApi;
import com.basbas.portalevent.network.RetroServer;
import com.basbas.portalevent.ui.register.RegisterActivity;
import com.basbas.portalevent.utils.MyFunction;

//setiap activity yang dibuat, di extends ke MyFunction
//supya bisa mendapatkan method pesan dan accseskelas
public class LoginActivity extends MyFunction {

    TextView tvGoToegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //untuk inisialisasi id dibuat dalam method initView
        //unutuk action button dibuat dalam method action button
        //dan untuk http koneksi ke server gunakan method baru
        initView();
        actionButton();
        postLogin();
    }

    private void postLogin() {
        RestApi api = RetroServer.getClient().create(RestApi.class);
    }

    private void actionButton() {
        tvGoToegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pesan("Ke register");
               aksesclass(RegisterActivity.class);
            }
        });
    }

    private void initView() {

        tvGoToegister = findViewById(R.id.tv_go_to_register);

    }
}
