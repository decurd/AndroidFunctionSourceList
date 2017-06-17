package com.decurd.androidfunctionsourcelist.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.decurd.androidfunctionsourcelist.R;
import com.decurd.androidfunctionsourcelist.fragment.CallbackFragment;

public class CallbackActivity extends AppCompatActivity implements CallbackFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_callback);
    }


    @Override
    public void onFragmentInteraction() {
        Toast.makeText(this, "인터렉션 이벤트가 발생하였습니다", Toast.LENGTH_SHORT).show();
    }
}
