package com.basbas.portalevent.ui.category;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.basbas.portalevent.R;
import com.basbas.portalevent.model.ResponseCategories;
import com.basbas.portalevent.network.RestApi;
import com.basbas.portalevent.pref.SessionPref;
import com.basbas.portalevent.utils.Constant;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PelaminanFragment extends Fragment {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    List<ResponseCategories> data;
    ProgressBar progressBar;
    SessionPref sessionPref;

      @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pelaminan, container, false);
          progressBar = view.findViewById(R.id.progress_cccircular);
          recyclerView = view.findViewById(R.id.rv_cccategories);
          recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return  view;
      }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getData();
    }

    private void getData() {
        progressBar.setVisibility(View.GONE);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RestApi api = retrofit.create(RestApi.class);
        Call<ArrayList<ResponseCategories>> response = api.getBarangCategories("jenis-0005");
        response.enqueue(new Callback<ArrayList<ResponseCategories>>() {
            @Override
            public void onResponse(Call<ArrayList<ResponseCategories>> call, Response<ArrayList<ResponseCategories>> response) {
                if(response.isSuccessful()){
                    progressBar.setVisibility(View.GONE);
                    ArrayList<ResponseCategories> dataResponse = response.body();
                    AdapterCategories adapterCategories = new AdapterCategories(getContext(),dataResponse);
                    recyclerView.setAdapter(adapterCategories);
                    adapterCategories.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<ResponseCategories>> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(getContext(), "gagal mendapatkan data", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
