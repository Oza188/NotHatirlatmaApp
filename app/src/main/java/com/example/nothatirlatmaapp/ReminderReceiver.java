package com.example.nothatirlatmaapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class ReminderReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String note = intent.getStringExtra("note");
        if (note != null) {
            Toast.makeText(context, "Hatırlatma: " + note, Toast.LENGTH_LONG).show();
        }
    }
}
