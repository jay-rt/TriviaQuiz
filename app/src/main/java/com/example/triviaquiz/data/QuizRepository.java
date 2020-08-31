package com.example.triviaquiz.data;

import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.example.triviaquiz.data.database.LocalQuiz;
import com.example.triviaquiz.data.database.QuizDatabase;
import com.example.triviaquiz.data.network.ServiceGenerator;
import com.example.triviaquiz.data.network.model.Quiz;
import com.example.triviaquiz.data.network.model.QuizWrapper;
import com.example.triviaquiz.util.Converters;

import java.util.List;
import java.util.stream.Collectors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuizRepository {

    private QuizDatabase database = ServiceGenerator.getDatabase();

    public LiveData<List<LocalQuiz>> getQuizList() {
        return database.getQuizDao().getQuizList();
    }

    public void loadQuizData() {

        ServiceGenerator.getService().getQuizzes().enqueue(new Callback<QuizWrapper>() {
            @Override
            public void onResponse(Call<QuizWrapper> call, Response<QuizWrapper> response) {
                if (response.body() != null && response.isSuccessful()) {
                    Log.e("yay", "data_in");
                    List<Quiz> httpQuiz = response.body().getResults();
                    Converters converters = new Converters();
                    List<LocalQuiz> quizList = httpQuiz.stream()
                            .map(it -> new LocalQuiz(it.getQuestion(),
                                    it.getCorrectAnswer(),
                                    converters.listToString(it.getInCorrectAnswers())))
                            .collect(Collectors.toList());

                    AsyncTask.execute(() -> database.getQuizDao().insertQuizData(quizList));
                }
            }

            @Override
            public void onFailure(Call<QuizWrapper> call, Throwable t) {

            }
        });
    }
}
