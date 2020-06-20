package com.basbas.portalevent.ui.category_home;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.basbas.portalevent.R;
import com.basbas.portalevent.ui.category.CateringFragment;
import com.basbas.portalevent.ui.category.DekorasiFragment;
import com.basbas.portalevent.ui.category.EventOrganizerFragment;
import com.basbas.portalevent.ui.category.HiburanFragment;
import com.basbas.portalevent.ui.category.PelaminanFragment;
import com.basbas.portalevent.ui.category.PhotoShootingFragment;
import com.basbas.portalevent.ui.main.MainActivity;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class TabActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    AdapterCategory adapterCategory;
    ArrayList<Fragment> arrayFragments;
    ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        getSupportActionBar().setTitle(getString(R.string.categories));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tabLayout = findViewById(R.id.tab_layout);
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        viewPager.setAdapter(adapterCategory);

        addFragment();
        addTittle();
        viewPager();
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
        adapterCategory = new AdapterCategory(getSupportFragmentManager(),arrayFragments,arrayList);
        viewPager.setAdapter(adapterCategory);

        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){
         onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }
}
