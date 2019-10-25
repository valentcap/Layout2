package com.example.layout2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    private EditText email;
    private EditText password;
    private Button login;
    private Button back;

    public static final String Email = "emailKey";
    public static final String MyPREFERENCES = "MyPrefs" ;
    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.txtEmail);
        password = findViewById(R.id.txtPassword);
        login = findViewById(R.id.btnSubmit);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        System.out.println("Login Email : "+ sharedpreferences.getString(Email, new String()));

        if(sharedpreferences.getString(Email, new String()).equals("valent.christian@ti.ukdw.ac.id")){
            Intent intent = new Intent( this, activity_home_page.class);
            startActivity(intent);
        }
    }

    public void Loginbaru(View view) {
        if(check(String.valueOf(email.getText()), String.valueOf(password.getText()))){
            Intent intent = new Intent( this, activity_home_page.class);
//            Bundle b = new Bundle();
//            b.putString("Email: ", email.getText().toString());
//            intent.putExtras(b);
            String teksemail = email.getText().toString();
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putString(Email, teksemail);
            editor.commit();
            Toast.makeText(MainActivity.this,"Thanks",Toast.LENGTH_LONG).show();
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
