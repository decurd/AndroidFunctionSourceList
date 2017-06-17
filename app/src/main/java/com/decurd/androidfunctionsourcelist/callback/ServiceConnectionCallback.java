package com.decurd.androidfunctionsourcelist.callback;

import android.support.customtabs.CustomTabsClient;

/**
 * Created by decur on 2017-06-17.
 */

public interface ServiceConnectionCallback {
    /**
     * Called when the service is connected.
     * @param client a CustomTabsClient
     */
    void onServiceConnected(CustomTabsClient client);

    /**
     * Called when the service is disconnected.
     */
    void onServiceDisconnected();
}
