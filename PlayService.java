package com.example.workingwithservices;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

public class PlayService extends Service {
    private MediaPlayer mPlay;


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this, "Создание", Toast.LENGTH_SHORT).show();
        mPlay = MediaPlayer.create(this, R.raw.melodiya_iphone_7);
        mPlay.setLooping(false);
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Запуск", Toast.LENGTH_SHORT).show();
        mPlay.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Остановка", Toast.LENGTH_SHORT).show();
        mPlay.stop();
    }
}
