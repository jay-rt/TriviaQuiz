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
    LiveData<List<LocalQuiz>> getQuizList();

    @Update
    void update(LocalQuiz localQuiz);

    @Query("DELETE FROM quiz_data")
    void deleteAll();

    @Query("UPDATE quiz_data set score = score + 1")
    void updateScore();

}
