//package com.example.beatbox.db;
//
//import android.content.Context;
//
//import androidx.room.Database;
//import androidx.room.Room;
//import androidx.room.RoomDatabase;
//
//import com.example.beatbox.model.User;
//
//@Database(entities = {User.class},version = 1)
//public abstract class AppDatabase extends RoomDatabase {
//
//    private static final String DATABASE_NAME = "git_db";
//
//    private static AppDatabase appDatabase;
//
//    public static synchronized AppDatabase getInstance(Context context){
//        if (appDatabase == null){
//            appDatabase = Room.databaseBuilder(context.getApplicationContext(),AppDatabase.class,DATABASE_NAME).build();
//        }
//        return appDatabase;
//    }
//    public abstract UserDao userDao();
//}