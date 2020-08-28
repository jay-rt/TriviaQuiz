package com.example.triviaquiz.data.network;

import com.example.triviaquiz.data.network.model.QuizWrapper;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("api.php?amount=10")
    Call<QuizWrapper> getQuizzes();
}
