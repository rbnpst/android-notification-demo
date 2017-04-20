package me.rpst.notificationdemo;

import android.app.Notification;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonCreate = (Button) findViewById(R.id.button_create);
        buttonCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createSingleNotification();
            }
        });

        Button buttonCreate2 = (Button) findViewById(R.id.button_create_2);
        buttonCreate2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createInboxStyleNotification();
            }
        });
    }

    private void createSingleNotification() {
        Notification notification = new NotificationCompat.Builder(getApplicationContext())
                .setContentTitle("New result(s)")
                .setContentText("You've received a 9 for Design Patterns")
                .setSmallIcon(R.drawable.ic_android_black_24dp)
                .build();
        NotificationManagerCompat.from(MainActivity.this).notify(new Random().nextInt(), notification);
    }

    private void createInboxStyleNotification() {
        Notification notification = new NotificationCompat.Builder(getApplicationContext())
                .setContentTitle("New Blackboard announcement(s)")
                .setContentText("just a subtitle")
                .setSmallIcon(R.drawable.ic_android_black_24dp)
                .setStyle(new NotificationCompat.InboxStyle()
                        .addLine("Indeling assessments")
                        .addLine("Beoordeling huiswerkopdrachten")
                        .setBigContentTitle("2 new Blackboard announcements"))
                .setGroupSummary(true)
                .build();

        NotificationManagerCompat.from(MainActivity.this).notify(new Random().nextInt(), notification);
    }
}
