package com.basbas.portalevent.ui.keranjang;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.basbas.portalevent.R;
import com.basbas.portalevent.model.ResponseKeranjang;
import com.basbas.portalevent.network.RestApi;
import com.basbas.portalevent.pref.SessionPref;
import com.basbas.portalevent.utils.Constant;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class KeranjangFragemnt extends Fragment {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    List<ResponseKeranjang> data;
    ProgressBar progressBar;
    SessionPref sessionPref;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.activity_keranjang, container, false);

        progressBar =view.findViewById(R.id.progres_keranjang);
        recyclerView = view.findViewById(R.id.rv_keranjang);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        getData();
        return view;
    }

    private void getData() {
        progressBar.setVisibility(View.VISIBLE);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RestApi api = retrofit.create(RestApi.class);
        Call<ArrayList<ResponseKeranjang>> responseKeranjangCall = api.getKeranjang("Login1590838121");
        responseKeranjangCall.enqueue(new Callback<ArrayList<ResponseKeranjang>>() {
            @Override
            public void onResponse(Call<ArrayList<ResponseKeranjang>> call, Response<ArrayList<ResponseKeranjang>> response) {
                if(response.isSuccessful()){
                    progressBar.setVisibility(View.GONE);
                    ArrayList<ResponseKeranjang> dataResponse = response.body();
                    AdapterKeranjang adapterKeranjang = new AdapterKeranjang(getActivity(),dataResponse);
                    recyclerView.setAdapter(adapterKeranjang);
                    adapterKeranjang.notifyDataSetChanged();
                }else {
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(getActivity(), "Data Kosong", Toast.LENGTH_SHORT).show();
                }

                Log.e("TAG","data berhasil "+new Gson().toJson(response.body()));
            }

            @Override
            public void onFailure(Call<ArrayList<ResponseKeranjang>> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(getContext(), "Data Kosong", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
