package com.example.layout2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClick(View v){
        TextView tv = (TextView) findViewById(R.id.notMember);

        //ubah
        tv.setText("Sudah diklik");

        //assign forecolor
        tv.setTextColor(Color.GREEN);


    }


}
