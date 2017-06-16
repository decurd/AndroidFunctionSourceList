package com.decurd.androidfunctionsourcelist.activity;

import android.Manifest;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.decurd.androidfunctionsourcelist.R;
import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.util.ArrayList;

public class TedpermissionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tedpermission);
    }

    public void checkPermisson(View view) {
        new TedPermission(this)
                .setRationaleMessage("이 기능은 외부 저장소에 접근 권한이 필요합니다")
                .setDeniedMessage("설정 메뉴에서 언제든지 권한을 변경할 수 있습니다")
                .setPermissions(Manifest.permission.READ_EXTERNAL_STORAGE)  // 여러개의 권한이 필요하면 콤마(,)를 넣고 더 추가할 수 있다.
                .setPermissionListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted() {
                        // 승인되었을 때
                        // 기능수행
                        functionExecute();
                    }

                    @Override
                    public void onPermissionDenied(ArrayList<String> deniedPermissions) {
                        // 거부되었을 때

                    }
                }).check();
    }

    private void functionExecute() {
        // 여기에 권한을 필요로 하는 기능을 정의한다.
        Toast.makeText(this, "권한이 필요한 기능을 넣습니다", Toast.LENGTH_SHORT).show();
    }
}
