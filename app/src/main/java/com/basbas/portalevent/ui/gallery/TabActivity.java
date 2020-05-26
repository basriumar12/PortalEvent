package com.basbas.portalevent.ui.gallery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.Toolbar;

import com.basbas.portalevent.R;
import com.basbas.portalevent.ui.category.Catering;
import com.basbas.portalevent.ui.category.Dekorasi;
import com.basbas.portalevent.ui.category.EventOrganizer;
import com.basbas.portalevent.ui.category.Hiburan;
import com.basbas.portalevent.ui.category.Pelaminan;
import com.basbas.portalevent.ui.category.PhotoShooting;
import com.google.android.material.tabs.TabLayout;

public class TabActivity extends AppCompatActivity {
    TabLayout tabLayout;
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        frameLayout = findViewById(R.id.frame_layout);
        tabLayout = findViewById(R.id.tabs);
        tabLayout.addTab(tabLayout.newTab().setText("Catering"));
        tabLayout.addTab(tabLayout.newTab().setText("Dekorasi"));
        tabLayout.addTab(tabLayout.newTab().setText("Event Organizer"));
        tabLayout.addTab(tabLayout.newTab().setText("Hiburan"));
        tabLayout.addTab(tabLayout.newTab().setText("Pelaminan"));
        tabLayout.addTab(tabLayout.newTab().setText("Photo Shooting"));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Fragment fragment = null;
                switch (tab.getPosition()){
                    case 0 :
                        fragment = new Catering();
                        break;
                    case 1:
                        fragment = new Dekorasi();
                        break;
                    case 2:
                        fragment = new EventOrganizer();
                        break;
                    case 3:
                        fragment = new Hiburan();
                        break;
                    case 4 :
                        fragment = new Pelaminan();
                        break;
                    case 5 :
                        fragment = new PhotoShooting();
                        break;
                }
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame_layout,fragment);
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                fragmentTransaction.commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}
