package com.example.beatbox.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.example.beatbox.R;
import com.example.beatbox.mmkv.MmkvSinger;

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
                    String cookie = MmkvSinger.getInstance().getMkn().decodeString("user_cookie");
                    if (cookie != null) {
                        Intent mainIntent = new Intent(SplashActivity.this, MainActivity.class);
                        startActivity(mainIntent);
                    } else {
                        Intent logIntent = new Intent(SplashActivity.this, LoginAndRegisterActivity.class);
                        startActivity(logIntent);
                    }

                }
            };
            countDownTimer.start();
        }
    }
}