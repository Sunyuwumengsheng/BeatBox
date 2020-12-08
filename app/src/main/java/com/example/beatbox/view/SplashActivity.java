package com.example.beatbox.view;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;

import com.example.beatbox.R;
import com.example.beatbox.global.GlobalData;
import com.example.beatbox.mmkv.MmkvTools;

/**
 * @author STY启动页
 */
public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        toLoginOrMain();
    }

    private CountDownTimer countDownTimer;

    private void toLoginOrMain() {
        if (countDownTimer == null) {
            countDownTimer = new CountDownTimer(3000, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {

                }

                @Override
                public void onFinish() {
                    countDownTimer.cancel();
                    Intent mainIntent = new Intent(SplashActivity.this, MainActivity.class);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        startActivity(mainIntent, ActivityOptions.makeSceneTransitionAnimation(SplashActivity.this).toBundle());
                    }
//                    String cookie = MmkvTools.getInstance().getString(GlobalData.COOKIE,null);
//                    if (cookie != null) {
//                        Log.d("cookie", cookie);
//
//                    } else {
//                        Intent logIntent = new Intent(SplashActivity.this, LoginActivity.class);
//                        startActivity(logIntent);
//                    }
                    finish();
                }
            };
            countDownTimer.start();
        }
    }
}