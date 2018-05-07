package com.example.a62645.fitness.Utils;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import com.example.a62645.fitness.Activity.ActivityActivity;
import com.example.a62645.fitness.Home.HomeActivity;
import com.example.a62645.fitness.Notification.NotificationActivity;
import com.example.a62645.fitness.R;
import com.example.a62645.fitness.Sleep.SleepActivity;

import static com.example.a62645.fitness.R.*;

public class BottomNavigationViewHelper {
    private static final String TAG = "BottomNavigationViewHel";

    public static void enableNavigation(final Context context, BottomNavigationView view){
        view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.navigation_home:
                        Intent intent1 = new Intent(context, HomeActivity.class);//ACTIVITY_NUM = 0
                        context.startActivity(intent1);
                        break;
                    case id.navigation_activity:
                        Intent intent2 = new Intent(context, ActivityActivity.class);//ACTIVITY_NUM = 1
                        context.startActivity(intent2);
                        break;
                    case id.navigation_sleep:
                        Intent intent3 = new Intent(context,SleepActivity.class);//ACTIVITY_NUM = 2
                        context.startActivity(intent3);
                        break;
                    case id.navigation_notifications:
                        Intent intent4 = new Intent(context, NotificationActivity.class);//ACTIVITY_NUM = 3
                        context.startActivity(intent4);
                        break;
                }

                return false;
            }
        });
    }
}

