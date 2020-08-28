package com.example.triviaquiz.ui.quiz;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.triviaquiz.data.network.model.Quiz;
import com.example.triviaquiz.databinding.ViewQuizQueBinding;

import java.util.ArrayList;
import java.util.List;

public class QuizAdapter extends RecyclerView.Adapter<QuizAdapter.QuizQueViewHolder> {

    private List<Quiz> quizList = new ArrayList<>();

    public void setQuizList(List<Quiz> quizList) {
        this.quizList = quizList;
    }

    @NonNull
    @Override
    public QuizQueViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return QuizQueViewHolder.from(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull QuizQueViewHolder holder, int position) {
        holder.bind(quizList.get(position));
    }

    @Override
    public int getItemCount() {
        return quizList.size();
    }

    public static class QuizQueViewHolder extends RecyclerView.ViewHolder {

        private ViewQuizQueBinding binding;

        public QuizQueViewHolder(@NonNull ViewQuizQueBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Quiz quiz) {
            binding.quizQuestion.setText(quiz.getQuestion());
            if (quiz.getAnswers().size() == 2) {
                binding.quizOptionA.setText(quiz.getAnswers().get(0));
                binding.quizOptionB.setText(quiz.getAnswers().get(1));
                binding.quizOptionC.setVisibility(View.GONE);
                binding.quizOptionD.setVisibility(View.GONE);
            } else {
                binding.quizOptionA.setText(quiz.getAnswers().get(0));
                binding.quizOptionB.setText(quiz.getAnswers().get(1));
                binding.quizOptionC.setText(quiz.getAnswers().get(0));
                binding.quizOptionD.setText(quiz.getAnswers().get(2));
            }
        }

        public static QuizQueViewHolder from (ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            ViewQuizQueBinding binding = ViewQuizQueBinding.inflate(inflater, parent, false);
            return new QuizQueViewHolder(binding);
        }


    }
}
