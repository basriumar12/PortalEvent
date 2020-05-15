package com.basbas.portalevent.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.basbas.portalevent.R;
import com.basbas.portalevent.model.ResponseData;
import com.basbas.portalevent.network.RestApi;
import com.basbas.portalevent.network.RetroServer;
import com.basbas.portalevent.ui.main.MainActivity;
import com.basbas.portalevent.ui.register.RegisterActivity;
import com.basbas.portalevent.utils.MyFunction;

import retrofit2.Call;

//setiap activity yang dibuat, di extends ke MyFunction
//supya bisa mendapatkan method pesan dan accseskelas
public class LoginActivity extends MyFunction {
    TextView edtUsername,edtPassword;
    Button btn_Login;
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
//        Call<ResponseData> userLogin = api.userLogin(
//        );
    }

    private void actionButton() {
        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aksesclass(MainActivity.class);
                String vUsername = edtUsername.getText().toString();
                String vPassword = edtPassword.getText().toString();
                if(vUsername.isEmpty() || vPassword.isEmpty()){
                    pesan("Jangan kosong ya");
                }else {
                    postLogin();

                }
            }
        });
        tvGoToegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pesan("Ke register");
               aksesclass(RegisterActivity.class);
            }
        });
    }

    private void initView() {
        edtUsername = findViewById(R.id.edt_username);
        edtPassword = findViewById(R.id.edt_password);
        btn_Login = findViewById(R.id.btn_login);
        tvGoToegister = findViewById(R.id.tv_go_to_register);
    }
}
