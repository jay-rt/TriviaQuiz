package com.example.triviaquiz.data.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {LocalQuiz.class}, version = 1)
public abstract class QuizDatabase extends RoomDatabase {
    public abstract QuizDao getQuizDao();
}
