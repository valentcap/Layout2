package com.example.layout2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
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
import android.widget.Toast;

public class activity_home_page extends AppCompatActivity {

    private boolean registeredreceiver;
    private WifiManager wifiManager;


    //broadcast receiver di kelas
//    private BroadcastReceiver receiver = new BroadcastReceiver() {
//        @Override
//        public void onReceive(Context context, Intent intent) {
//            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
//            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
//            if(networkInfo!=null){
//                //ngapain kalo connect MASIH MUNCUL FALSE SEMUA
//                if(networkInfo.getType() == ConnectivityManager.TYPE_WIFI){
//                    wifistatus = networkInfo.isConnected();
//                    System.out.println("Status: "+ wifistatus);
//                }else{
//                    wifistatus = networkInfo.isConnected();
//                    System.out.println("Status: "+ wifistatus);
//                }
//            }
//        }
//    };
//
//    protected void onResume(){
//        super.onResume();
//        if(!registeredreceiver){
//            registeredreceiver = true;
//            registerReceiver(receiver, new IntentFilter("android.net.wifi.STATE_CHANGE"));
//        }
//
//    }
//
//    protected void onPause(){
//        super.onPause();
//        if(registeredreceiver){
//
//        }
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        Intent intent = getIntent();

        //tes wifi
        wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);


        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));

        Bundle b = intent.getExtras();
        String dataemail = b.getString("Email: ", "");
        Toast.makeText(getApplicationContext(),"Selamat datang, "+dataemail, Toast.LENGTH_SHORT).show();


        //cek wifi
        if(wifiManager.isWifiEnabled()){
            System.out.println("Wifi Enabled");
        }else{
            System.out.println("Wifi Disabled");
        }



//        TabLayout tabLayout = findViewById(R.id.tab_layout);
//        tabLayout.setupWithViewPager(viewPager);

        //prepareFragment();


    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION);
        registerReceiver(wifiStatusReceiver, intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(wifiStatusReceiver);
    }

    private BroadcastReceiver wifiStatusReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int wifiStateExtra = intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE, WifiManager.WIFI_STATE_UNKNOWN);

            switch (wifiStateExtra){
                case WifiManager.WIFI_STATE_ENABLED:
                    System.out.println("Wifi Enabled");
                    break;
                case WifiManager.WIFI_STATE_DISABLED:
                    System.out.println("Wifi Disabled");
                    break;
        }
        }
    };


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
