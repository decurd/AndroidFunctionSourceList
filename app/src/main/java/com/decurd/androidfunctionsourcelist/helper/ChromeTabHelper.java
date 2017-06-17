package com.decurd.androidfunctionsourcelist.helper;

import android.app.ActivityOptions;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.customtabs.CustomTabsIntent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import com.decurd.androidfunctionsourcelist.MainActivity;
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
        prepareMenuItems(builder, activity);
        prepareActionButton(builder, activity);
        builder.setCloseButtonIcon(backArrowBitmap);    // 이 부분을 추가하지 않으면 기본 x표시가 된다
        // builder.setCloseButtonIcon(BitmapFactory.decodeResource(activity.getResources(), R.drawable.ic_arrow_back));
        builder.setStartAnimations(activity, R.anim.slide_in_right, R.anim.slide_out_left);
        builder.setExitAnimations(activity, R.anim.slide_in_left, R.anim.slide_out_right);
        CustomTabsIntent intent = builder.build();
        intent.launchUrl(activity, Uri.parse(url));
    }

    private void prepareMenuItems(CustomTabsIntent.Builder builder, AppCompatActivity activity) {
        Intent menuIntent = new Intent();
        menuIntent.setClass(activity, MainActivity.class);  // 이동할 activity class 지정
        // Optional animation configuration when the user clicks menu items.
        Bundle menuBundle = ActivityOptions.makeCustomAnimation(activity, android.R.anim.slide_in_left,
                android.R.anim.slide_out_right).toBundle();
        PendingIntent pi = PendingIntent.getActivity(activity, 0, menuIntent, 0, menuBundle);
        builder.addMenuItem("메뉴#1", pi);
    }

    private void prepareActionButton(CustomTabsIntent.Builder builder, AppCompatActivity activity) {
        // An example intent that sends an email.
        Intent actionIntent = new Intent(Intent.ACTION_SEND);
        actionIntent.setType("*/*");
        actionIntent.putExtra(Intent.EXTRA_EMAIL, "example@example.com");
        actionIntent.putExtra(Intent.EXTRA_SUBJECT, "example");
        PendingIntent pi = PendingIntent.getActivity(activity, 0, actionIntent, 0);
        Bitmap icon = BitmapFactory.decodeResource(activity.getResources(), R.drawable.ic_share);
        builder.setActionButton(icon, "send email", pi, true);
    }

}
