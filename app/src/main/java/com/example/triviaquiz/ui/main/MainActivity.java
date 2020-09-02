package com.example.triviaquiz.ui.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.triviaquiz.data.database.LocalQuiz;
import com.example.triviaquiz.data.database.QuizDatabase;
import com.example.triviaquiz.data.network.ServiceGenerator;
import com.example.triviaquiz.data.network.model.QuizWrapper;
import com.example.triviaquiz.databinding.ActivityMainBinding;
import com.example.triviaquiz.ui.quiz.QuizActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.gameStart.setOnClickListener(v -> {
            Intent intent = new Intent(this, QuizActivity.class);
            startActivity(intent);
        });
    }
}