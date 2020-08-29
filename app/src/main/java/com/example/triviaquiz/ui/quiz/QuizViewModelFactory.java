package com.example.triviaquiz.ui.quiz;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.triviaquiz.data.QuizRepository;

public class QuizViewModelFactory implements ViewModelProvider.Factory {

    private QuizRepository repository;

    public QuizViewModelFactory(QuizRepository repository) {
        this.repository = repository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(QuizViewModel.class)) {
            return (T) new QuizViewModel(repository);
        }

        throw new IllegalArgumentException("Invalid ViewModel");
    }
}
