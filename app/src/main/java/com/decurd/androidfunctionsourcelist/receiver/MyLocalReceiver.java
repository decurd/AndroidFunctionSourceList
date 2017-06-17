package com.decurd.androidfunctionsourcelist.receiver;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.widget.Toast;

import com.decurd.androidfunctionsourcelist.MainActivity;
import com.decurd.androidfunctionsourcelist.R;

/**
 * Created by decurd on 2017-06-17.
 */

public class MyLocalReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Intent.ACTION_BATTERY_LOW)) {
            Toast.makeText(context, "로컬 브로드캐스트 리시버다", Toast.LENGTH_LONG).show();
        } else if (intent.getAction().equals(Intent.ACTION_POWER_CONNECTED)) {
            Toast.makeText(context, "전원 연결됨", Toast.LENGTH_LONG).show();
        } else if (intent.getAction().equals("MY_ACTION")) {
            Toast.makeText(context, "나만의 액션 받기 성공", Toast.LENGTH_LONG).show();
        }

        showNotification(context);
    }

    private void showNotification(Context context) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);

        builder.setContentTitle("나만의 알림");
        builder.setContentText("나만의 텍스트");
        builder.setSmallIcon(R.mipmap.ic_launcher_round);
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher);
        builder.setLargeIcon(bitmap);

        // 알림을 클릭하면 수행될 인텐트
        Intent resultIntent = new Intent(context, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, resultIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);
        // 클릭하면 날라감
        builder.setAutoCancel(true);

        // 색상
        builder.setColor(Color.YELLOW);

        // 기본 알림음
        Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        builder.setSound(uri);

        // 진동패턴

        // 알림표시
        NotificationManagerCompat manager = NotificationManagerCompat.from(context);
        manager.notify(0, builder.build());
    }
}
