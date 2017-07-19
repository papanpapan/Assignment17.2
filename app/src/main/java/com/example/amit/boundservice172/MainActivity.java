package com.example.amit.boundservice172;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    MyService myService;
    TextView textView;
    boolean isBind=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent=new Intent(this,MyService.class);
        bindService(intent,serviceConnection, Context.BIND_AUTO_CREATE);
        textView=(TextView)findViewById(R.id.textView2);
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void StartService(View view){
        String messege;
messege=myService.getTimeandDate();
        textView.setText(messege);

    }
    public ServiceConnection serviceConnection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MyService.LocalService localService= (MyService.LocalService) iBinder;
            myService=localService.getService();
            isBind=true;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            isBind=false;

        }
    };

    @Override
    protected void onStop() {
        if(isBind)
        {
            unbindService(serviceConnection);
            isBind=false;
        }
        super.onStop();
    }
}