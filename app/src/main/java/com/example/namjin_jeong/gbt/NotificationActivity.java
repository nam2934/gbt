package com.example.namjin_jeong.gbt;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationMenu;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class NotificationActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    Intent intent0 = new Intent(NotificationActivity.this, MainActivity.class);
                    startActivity(intent0);
                    overridePendingTransition(R.anim.not_move_activity,R.anim.not_move_activity);
                    return true;
                case R.id.navigation_search:
                    Intent intent1 = new Intent(NotificationActivity.this, SearchActivity.class);
                    startActivity(intent1);
                    overridePendingTransition(R.anim.not_move_activity,R.anim.not_move_activity);
                    return true;
                case R.id.navigation_register:
                    Intent intent2 = new Intent(NotificationActivity.this, RegisterActivity.class);
                    startActivity(intent2);
                    overridePendingTransition(R.anim.not_move_activity,R.anim.not_move_activity);
                    return true;
                case R.id.navigation_notifications:
                    return true;
                case R.id.navigation_setting:
                    Intent intent4 = new Intent(NotificationActivity.this, SettingActivity.class);
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
        setContentView(R.layout.activity_notification);

        mTextMessage = (TextView) findViewById(R.id.message);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        BottomNavigationViewHelper.removeShiftMode(navigation);
        Menu menu = navigation.getMenu();
        MenuItem menuItem = menu.getItem(3);
        menuItem.setChecked(true);
    }

    private long time= 0;
    @Override
    public void onBackPressed() {
        ActivityCompat.finishAffinity(this);
        System.runFinalizersOnExit(true);
        System.exit(0);
    }

}
