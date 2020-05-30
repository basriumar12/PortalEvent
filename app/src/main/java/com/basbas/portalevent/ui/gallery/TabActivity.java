package com.basbas.portalevent.ui.gallery;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;
import com.basbas.portalevent.R;
import com.basbas.portalevent.ui.category.Adapter;
import com.basbas.portalevent.ui.category.Catering;
import com.basbas.portalevent.ui.category.DekorasiFragment;
import com.basbas.portalevent.ui.category.EventOrganizer;
import com.basbas.portalevent.ui.category.Hiburan;
import com.basbas.portalevent.ui.category.Pelaminan;
import com.basbas.portalevent.ui.category.PhotoShooting;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class TabActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    Adapter adapter;
    ArrayList<Fragment> arrayFragments;
    ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        tabLayout = findViewById(R.id.tab_layout);
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        viewPager.setAdapter(adapter);

        addFragment();
        addTittle();
        viewPager();
    }
    private void addFragment(){
        arrayFragments = new ArrayList<>();
        arrayFragments.add(new Catering());
        arrayFragments.add(new DekorasiFragment());
        arrayFragments.add(new EventOrganizer());
        arrayFragments.add(new Hiburan());
        arrayFragments.add(new Pelaminan());
        arrayFragments.add(new PhotoShooting());
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
        adapter = new Adapter(getSupportFragmentManager(),arrayFragments,arrayList);
        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);
    }
}
