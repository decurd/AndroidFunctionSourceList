package com.decurd.androidfunctionsourcelist.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.decurd.androidfunctionsourcelist.R;
import com.decurd.androidfunctionsourcelist.helper.ChromeTabHelper;

public class ChromeCustomTabsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chrome_custom_tabs);

        String url = "http://m.naver.com";
        new ChromeTabHelper().launchChromeTab(ChromeCustomTabsActivity.this, url);
    }
}
