package cimdata.android.dez2017.localbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Hier erstellen wir den Reciever
    BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, "Hier bin ich", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_acmain_cast). setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent("unsere_action");

                LocalBroadcastManager
                        .getInstance(MainActivity.this)
                        .sendBroadcast(intent);

            }
        });
    }


    // Hier registrieren wir den reciever
    @Override
    protected void onResume() {
        super.onResume();

        LocalBroadcastManager
                .getInstance(this)
                .registerReceiver(
                        broadcastReceiver, // Den Receiver, der die Daten empfangen soll
                        new IntentFilter("unsere_action")

                );



    }

    @Override
    protected void onPause() {
        super.onPause();
        LocalBroadcastManager
                .getInstance(this)
                .unregisterReceiver(broadcastReceiver);
    }
}
