package com.decurd.androidfunctionsourcelist.activity;

import android.os.Bundle;
import android.support.customtabs.CustomTabsClient;
import android.support.customtabs.CustomTabsServiceConnection;
import android.support.customtabs.CustomTabsSession;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;

import com.decurd.androidfunctionsourcelist.R;
import com.decurd.androidfunctionsourcelist.callback.ServiceConnectionCallback;
import com.decurd.androidfunctionsourcelist.helper.ChromeTabHelper;
import com.decurd.androidfunctionsourcelist.helper.CustomTabsHelper;
import com.decurd.androidfunctionsourcelist.util.ServiceConnection;

public class ChromeCustomTabsActivity extends AppCompatActivity implements ServiceConnectionCallback {

    CustomTabsServiceConnection mConnection;
    CustomTabsSession mCustomTabsSession;
    CustomTabsClient mClient;
    String mPackageNameToBind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chrome_custom_tabs);

        bindCustomTabsService();

        String url = "http://m.daum.net";
        new ChromeTabHelper().launchChromeTab(ChromeCustomTabsActivity.this, url);
    }

    @Override
    protected void onDestroy() {
        unbindCustomTabsService();
        super.onDestroy();
    }

    private void bindCustomTabsService() {
        if (mClient != null) return;
        if (TextUtils.isEmpty(mPackageNameToBind)) {
            mPackageNameToBind = CustomTabsHelper.getPackageNameToUse(this);
            if (mPackageNameToBind == null) return;
        }
        mConnection = new ServiceConnection(this);
        boolean ok = CustomTabsClient.bindCustomTabsService(this, mPackageNameToBind, mConnection);
        if (!ok) {
            mConnection = null;
        }
    }

    private void unbindCustomTabsService() {
        if (mConnection == null) return;
        unbindService(mConnection);
        mClient = null;
        mCustomTabsSession = null;
    }

    @Override
    public void onServiceConnected(CustomTabsClient client) {
        mClient = client;
    }

    @Override
    public void onServiceDisconnected() {
        mClient = null;
    }
}
