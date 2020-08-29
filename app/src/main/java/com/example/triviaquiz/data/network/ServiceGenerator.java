package com.example.triviaquiz.data.network;

import android.content.Context;

import androidx.room.Room;

import com.example.triviaquiz.data.database.QuizDatabase;
import com.example.triviaquiz.util.TriviaQuizConst;

import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class ServiceGenerator {

    private static QuizDatabase DATABASE;
    private static ApiService SERVICE;

    private ServiceGenerator() {
        //Private constructor to prevent object creation
    }

    public static ApiService getService() {
        return SERVICE;
    }

    public static QuizDatabase getDatabase() {
        return DATABASE;
    }

    public static void initialize(Context context) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(TriviaQuizConst.BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .build();

        SERVICE = retrofit.create(ApiService.class);

        DATABASE = Room.databaseBuilder(context,
                QuizDatabase.class,
                "quiz_database")
                .fallbackToDestructiveMigration()
                .build();
    }
}
