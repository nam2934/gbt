package com.example.namjin_jeong.gbt;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Intent intent0 = new Intent(RegisterActivity.this, MainActivity.class);
                    startActivity(intent0);
                    return true;
                case R.id.navigation_search:
                    Intent intent1 = new Intent(RegisterActivity.this, SearchActivity.class);
                    startActivity(intent1);
                    return true;
                case R.id.navigation_register:
                    mTextMessage.setText(R.string.title_register);
                    return true;
                case R.id.navigation_notifications:
                    Intent intent3 = new Intent(RegisterActivity.this, NotificationActivity.class);
                    startActivity(intent3);
                    return true;
                case R.id.navigation_setting:
                    Intent intent4 = new Intent(RegisterActivity.this, SettingActivity.class);
                    startActivity(intent4);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mTextMessage = (TextView) findViewById(R.id.message);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        BottomNavigationViewHelper.removeShiftMode(navigation);
        Menu menu = navigation.getMenu();
        MenuItem menuItem = menu.getItem(2);
        menuItem.setChecked(true);
    }

}
