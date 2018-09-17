package com.example.namjin_jeong.gbt;


import android.content.Intent;
import android.content.Context;
import android.graphics.Rect;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView mTextMessage;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    return true;
                case R.id.navigation_search:
                    Intent intent1 = new Intent(MainActivity.this, SearchActivity.class);
                    startActivity(intent1);
                    overridePendingTransition(R.anim.not_move_activity,R.anim.not_move_activity);
                    return true;
                case R.id.navigation_register:
                    Intent intent2 = new Intent(MainActivity.this, RegisterActivity.class);
                    startActivity(intent2);
                    overridePendingTransition(R.anim.not_move_activity,R.anim.not_move_activity);
                    return true;
                case R.id.navigation_notifications:
                    Intent intent3 = new Intent(MainActivity.this, NotificationActivity.class);
                    startActivity(intent3);
                    overridePendingTransition(R.anim.not_move_activity,R.anim.not_move_activity);
                    return true;
                case R.id.navigation_setting:
                    Intent intent4 = new Intent(MainActivity.this, SettingActivity.class);
                    startActivity(intent4);
                    overridePendingTransition(R.anim.not_move_activity,R.anim.not_move_activity);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        BottomNavigationViewHelper.removeShiftMode(navigation);
        Menu menu = navigation.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(true);
    }
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if ( v instanceof EditText) {
                Rect outRect = new Rect();
                v.getGlobalVisibleRect(outRect);
                if (!outRect.contains((int)event.getRawX(), (int)event.getRawY())) {
                    v.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
        }
        return super.dispatchTouchEvent( event );
    }
    private long time= 0;
    @Override
    public void onBackPressed() {
        ActivityCompat.finishAffinity(this);
        System.runFinalizersOnExit(true);
        System.exit(0);
    }



}
