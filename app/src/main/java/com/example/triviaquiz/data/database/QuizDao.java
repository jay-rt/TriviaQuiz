package com.example.triviaquiz.data.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface QuizDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertQuizData(List<LocalQuiz> quizList);

    @Query("SELECT * FROM quiz_data")
    LiveData<List<LocalQuiz>> getQuizQues();

    @Update
    void update(LocalQuiz localQuiz);
}
