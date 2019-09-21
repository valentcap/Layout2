package com.example.layout2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    private EditText email;
    private EditText password;
    private Button login;
    private Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.txtEmail);
        password = findViewById(R.id.txtPassword);
        login = findViewById(R.id.btnSubmit);


    }

    public void Loginbaru(View view) {
        if(check(String.valueOf(email.getText()), String.valueOf(password.getText()))){
            Intent intent = new Intent( this, activity_home_page.class);
            Bundle b = new Bundle();
            b.putString("Email: ", email.getText().toString());
            intent.putExtras(b);
            finish();
            startActivity(intent);
        }
    }

    public void onClick(View v){
        TextView tv = (TextView) findViewById(R.id.notMember);
        //ubah
        tv.setText("Sudah diklik");
        //assign forecolor
        tv.setTextColor(Color.GREEN);
    }

    public static boolean check(String email, String password){
        return email.equals("valent.christian@ti.ukdw.ac.id") && password.equals("abcd");
    }



//    private void move(){
//        back = findViewById(R.id.button_fragment);
//        back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent about = new Intent(MainActivity.this, About.class);
//                startActivity(about);
//            }
//        });
//    }

}
