package com.example.layout2;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class activity_home_page extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        Intent intent = getIntent();
        prepareFragment();


    }


    public void toAbout(View view) {
        Intent intent = new Intent(this, About.class);
        //EditText editText = (EditText) findViewById(R.id.txtEmail);
        startActivity(intent);
    }

    private void prepareFragment(){
        this.getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_pakai_menu, new fragment_menu()).commit();
    }

}
