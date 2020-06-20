package com.basbas.portalevent.ui.category_home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.basbas.portalevent.R;
import com.basbas.portalevent.ui.category.CateringFragment;
import com.basbas.portalevent.ui.category.DekorasiFragment;
import com.basbas.portalevent.ui.category.EventOrganizerFragment;
import com.basbas.portalevent.ui.category.HiburanFragment;
import com.basbas.portalevent.ui.category.PelaminanFragment;
import com.basbas.portalevent.ui.category.PhotoShootingFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class CategoryHome extends Fragment{
    TabLayout tabLayout;
    ViewPager viewPager;
    AdapterCategory adapterCategory;
    ArrayList<Fragment> arrayFragments;
    ArrayList<String> arrayList;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        View view =  inflater.inflate(R.layout.activity_tab, container, false);
        tabLayout = view.findViewById(R.id.tab_layout);
        viewPager = view.findViewById(R.id.view_pager);
        viewPager.setAdapter(adapterCategory);

        addFragment();
        addTittle();
        viewPager();
        return view;
    }
    private void addFragment(){
        arrayFragments = new ArrayList<>();
        arrayFragments.add(new CateringFragment());
        arrayFragments.add(new DekorasiFragment());
        arrayFragments.add(new EventOrganizerFragment());
        arrayFragments.add(new HiburanFragment());
        arrayFragments.add(new PelaminanFragment());
        arrayFragments.add(new PhotoShootingFragment());
    }

    private void addTittle(){
        arrayList = new ArrayList<>();
        arrayList.add("Catering");
        arrayList.add("Dekorasi");
        arrayList.add("Event Oragnizer");
        arrayList.add("Hiburan");
        arrayList.add("Pelaminan");
        arrayList.add("Photo Shooting");
    }

    private void viewPager(){
        adapterCategory = new AdapterCategory(getChildFragmentManager(),arrayFragments,arrayList);
        viewPager.setAdapter(adapterCategory);

        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}
