package com.example.namjin_jeong.gbt;


import android.content.Intent;
import android.content.Context;
import android.graphics.Rect;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mTextMessage;
    private ImageButton addPostButton;
    private LinearLayout postLinearLayout;
    private EditText nameEditText;
    private PostTextView textView1;
    private PostTextView textView2;
    private LinearLayout addpostLinearLayout;
    private ScrollView postScrollView;



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

        mTextMessage = (TextView) this.findViewById(R.id.message);
        addPostButton = (ImageButton) this.findViewById(R.id.addpostbutton);

        nameEditText = new EditText(this);
        nameEditText.setGravity(Gravity.CENTER);
        nameEditText.setText("제목");



        addpostLinearLayout = new LinearLayout(this);
        addpostLinearLayout.addView(nameEditText);





        textView1 = new PostTextView(this);
        textView1.setText("#FUCK\nHELLO");

        textView2 = new PostTextView(this);
        textView2.setText("#FUCK123\nHELLO222");

        postLinearLayout = new LinearLayout(this);
        postLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        postLinearLayout.setOrientation(LinearLayout.VERTICAL);
        postLinearLayout.addView(textView1);
        postLinearLayout.addView(textView2);


        postScrollView = (ScrollView) this.findViewById(R.id.postscrollview);
        postScrollView.addView(postLinearLayout);

        addPostButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(postLinearLayout.getParent() != null ) {
                    postScrollView.removeView(postLinearLayout);
                    postScrollView.addView(addpostLinearLayout);
                }
            }
        });

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
        moveTaskToBack(true);
        finish();
        android.os.Process.killProcess(android.os.Process.myPid());
    }



}
