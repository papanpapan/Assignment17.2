package com.example.amit.boundservice172;

import android.app.Service;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.icu.util.IndianCalendar;
import android.icu.util.TimeZone;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;

import java.util.Date;
import java.util.Locale;

/**
 * Created by Amit on 7/4/2017.
 */

public class MyService extends Service {
    private final IBinder binder=new LocalService();
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }
        public class LocalService extends Binder {
            MyService getService() {
                return MyService.this;
            }
        }
        @RequiresApi(api = Build.VERSION_CODES.N)
        public String getTimeandDate(){
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("HH:mm:ss......MM/dd/yyyy", Locale.UK);
            return (simpleDateFormat.format(new Date()));
        }

    }
