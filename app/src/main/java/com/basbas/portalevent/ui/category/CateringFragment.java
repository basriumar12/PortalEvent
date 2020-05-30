package com.basbas.portalevent.ui.category;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.basbas.portalevent.R;
import com.basbas.portalevent.model.ResponseCatering;
import com.basbas.portalevent.ui.AdapterCategory.CateringAdapter;
import java.util.List;

public class CateringFragment extends Fragment {
//    CateringAdapter cateringAdapter;
//    RecyclerView recyclerView;
//    List<ResponseCatering> responseCaterings;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_catering, container, false);
//       recyclerView = view.findViewById(R.id.rv_catering);
//       recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//       getDataCatering();
       return view;
    }


//    private void getDataCatering() {
//        //parsing json disini
//    }

}
