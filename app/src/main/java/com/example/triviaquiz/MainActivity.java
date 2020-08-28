package com.example.triviaquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.triviaquiz.data.network.model.QuizWrapper;
import com.example.triviaquiz.databinding.ActivityMainBinding;

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

//        TextView text = findViewById(R.id.text);

        ServiceGenerator.getService().getQuizzes().enqueue(new Callback<QuizWrapper>() {
            @Override
            public void onResponse(Call<QuizWrapper> call, Response<QuizWrapper> response) {
                if (response.body() != null && response.isSuccessful()) {
                    binding.text.setText(response.body().getResults().toString());
                }
            }

            @Override
            public void onFailure(Call<QuizWrapper> call, Throwable t) {

            }
        });
    }
}