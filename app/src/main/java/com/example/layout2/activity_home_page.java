package com.example.layout2;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class activity_home_page extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        Intent intent = getIntent();


        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));


//        TabLayout tabLayout = findViewById(R.id.tab_layout);
//        tabLayout.setupWithViewPager(viewPager);

        //prepareFragment();


    }

    //tugas sebelumnya
//    public void toAbout(View view) {
//        Intent intent = new Intent(this, About.class);
//        //EditText editText = (EditText) findViewById(R.id.txtEmail);
//        startActivity(intent);
//    }

//    private void prepareFragment(){
//        this.getSupportFragmentManager().beginTransaction()
//                .add(R.id.fragment_pakai_menu, new fragment_menu()).commit();
//    }

}
