package com.example.a62645.fitness.Notification;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.a62645.fitness.R;

public class AccountSettingsActivity extends AppCompatActivity {


    private static final String TAG = "AccountSettingsActivity";

    private Context mContext = AccountSettingsActivity.this;

    private ViewPager mViewPager;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editprofile);
        Log.d(TAG, "onCreate: started");



        //setup the backarraw for navigating back to "ProfileActivity"
        ImageView backArrow = (ImageView) findViewById(R.id.backArrow);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: naviagating back to 'ProfileActivity'");
                finish();
            }
        });
    }
}
