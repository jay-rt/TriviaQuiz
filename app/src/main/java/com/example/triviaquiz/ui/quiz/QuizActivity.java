package com.example.triviaquiz.ui.quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.triviaquiz.R;
import com.example.triviaquiz.data.QuizRepository;
import com.example.triviaquiz.data.network.ServiceGenerator;
import com.example.triviaquiz.data.network.model.QuizWrapper;
import com.example.triviaquiz.databinding.ActivityQuizBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuizActivity extends AppCompatActivity {

    private ActivityQuizBinding binding;
    private QuizViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityQuizBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        QuizRepository repository = new QuizRepository();
        QuizViewModelFactory factory = new QuizViewModelFactory(repository);
        viewModel = new ViewModelProvider(this, factory).get(QuizViewModel.class);

        QuizAdapter adapter = new QuizAdapter(ans -> {
            Toast.makeText(QuizActivity.this, "Ans: " + ans, Toast.LENGTH_SHORT).show();
        });
        binding.quizRecyclerView.setAdapter(adapter);

        viewModel.getQuizList().observe(this, adapter::submitList);

    }
}