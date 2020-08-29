package com.example.triviaquiz.data;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.triviaquiz.data.network.ServiceGenerator;
import com.example.triviaquiz.data.network.model.Quiz;
import com.example.triviaquiz.data.network.model.QuizWrapper;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuizRepository {

    private MutableLiveData<List<Quiz>> quizList = new MutableLiveData<>();

    public LiveData<List<Quiz>> getQuizList() {
        return quizList;
    }

    public void loadQuizData() {

        ServiceGenerator.getService().getQuizzes().enqueue(new Callback<QuizWrapper>() {
            @Override
            public void onResponse(Call<QuizWrapper> call, Response<QuizWrapper> response) {
                if (response.body() != null && response.isSuccessful()) {
                    quizList.setValue(response.body().getResults());
                }
            }

            @Override
            public void onFailure(Call<QuizWrapper> call, Throwable t) {

            }
        });
    }
}
