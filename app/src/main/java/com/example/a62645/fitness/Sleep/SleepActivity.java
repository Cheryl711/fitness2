package com.example.a62645.fitness.Sleep;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import com.example.a62645.fitness.R;
import com.example.a62645.fitness.Utils.BottomNavigationViewHelper;

public class SleepActivity extends AppCompatActivity {
    private static final String TAG = "ActivityActivity";
    private Context mContext = SleepActivity.this;

    private static final int ACTIVITY_NUM=2;
    private TextView tv_date;
    private TextView tv_content;
    private DatabaseReference mReference;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore);

        setupBottomNavigationView();

        //初始化控件
        iniUI();
        //初始化数据
        initData();

    }

    private void setupBottomNavigationView() {
        Log.d(TAG, "setupBottomNavigationView: setting up BottomNavigationView");
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavViewBar);
        BottomNavigationViewHelper.enableNavigation(mContext, bottomNavigationView);

        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);

    }
    private void initData() {
        //构建数据库实例对象，引用为mReference
        mReference = FirebaseDatabase.getInstance().getReference();
        //通过键名，获取数据库实例对象的子节点对象
        DatabaseReference date = mReference.child("date");
        DatabaseReference content = mReference.child("content");

        //注册子第一个节点对象数据变化的监听者对象
        date.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //数据库数据变化时调用此方法
                String value = dataSnapshot.getValue(String.class);
                tv_date.setText("date：" + value);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        //注册子第二个节点对象数据变化的监听者对象
        content.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //数据库数据变化时调用此方法
                String value = dataSnapshot.getValue(String.class);
                tv_content.setText("content：" + value);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void iniUI() {
        tv_date = (TextView) findViewById(R.id.tv_date);
        tv_content = (TextView) findViewById(R.id.tv_content);
    }
}
