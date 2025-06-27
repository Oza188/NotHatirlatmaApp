package com.example.nothatirlatmaapp;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText editTextNote;
    TimePicker timePicker;
    Button buttonSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNote = findViewById(R.id.editTextNote);
        timePicker = findViewById(R.id.timePicker);
        buttonSave = findViewById(R.id.buttonSave);

        buttonSave.setOnClickListener(view -> {
            String note = editTextNote.getText().toString().trim();

            if (!note.isEmpty()) {
                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.HOUR_OF_DAY, timePicker.getHour());
                calendar.set(Calendar.MINUTE, timePicker.getMinute());
                calendar.set(Calendar.SECOND, 0);

                if (calendar.before(Calendar.getInstance())) {
                    calendar.add(Calendar.DATE, 1); // geçmiş saatse yarına ayarla
                }

                Intent intent = new Intent(MainActivity.this, ReminderReceiver.class);
                intent.putExtra("note", note);

                PendingIntent pendingIntent = PendingIntent.getBroadcast(
                        MainActivity.this, 0, intent,
                        PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE
                );

                AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                if (alarmManager != null) {
                    alarmManager.setExact(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
                    Toast.makeText(MainActivity.this, "Hatırlatma ayarlandı!", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(MainActivity.this, "Not boş olamaz!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
