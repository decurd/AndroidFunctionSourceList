package com.decurd.androidfunctionsourcelist.helper;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.customtabs.CustomTabsIntent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import com.decurd.androidfunctionsourcelist.R;

/**
 * Created by decurd on 2017-06-17.
 */

public class ChromeTabHelper {

    public void launchChromeTab(AppCompatActivity activity, String url) {

        // Bitmap backArrowBitmap = doodleBitmapFactory.createBitmapFromVector(activity.getResources(), R.drawable.back_arrow_vector);

        Bitmap backArrowBitmap  = BitmapFactory.decodeResource(activity.getResources(), R.drawable.ic_arrow_back_black_24dp);

        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        builder.setToolbarColor(ContextCompat.getColor(activity, R.color.white));
        builder.setShowTitle(true); // 타이틀 보이기
        builder.setCloseButtonIcon(backArrowBitmap);    // 이 부분을 추가하지 않으면 기본 x표시가 된다

        CustomTabsIntent intent = builder.build();
        intent.launchUrl(activity, Uri.parse(url));
    }

}
