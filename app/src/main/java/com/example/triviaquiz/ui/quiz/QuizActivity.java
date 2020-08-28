package com.example.triviaquiz.ui.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.triviaquiz.R;
import com.example.triviaquiz.data.network.ServiceGenerator;
import com.example.triviaquiz.data.network.model.QuizWrapper;
import com.example.triviaquiz.databinding.ActivityQuizBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuizActivity extends AppCompatActivity {

    private ActivityQuizBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityQuizBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        QuizAdapter adapter = new QuizAdapter();
        binding.quizRecyclerView.setAdapter(adapter);

        ServiceGenerator.getService().getQuizzes().enqueue(new Callback<QuizWrapper>() {
            @Override
            public void onResponse(Call<QuizWrapper> call, Response<QuizWrapper> response) {
                if (response.body() != null && response.isSuccessful()) {
                    Log.e("respose", "yay");
                    adapter.setQuizList(response.body().getResults());
                    Log.e("transferring_value", "yay");
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<QuizWrapper> call, Throwable t) {

            }
        });
    }
}