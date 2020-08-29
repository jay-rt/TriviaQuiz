package com.example.triviaquiz.ui.quiz;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.triviaquiz.data.QuizRepository;
import com.example.triviaquiz.data.network.ServiceGenerator;
import com.example.triviaquiz.data.network.model.Quiz;
import com.example.triviaquiz.data.network.model.QuizWrapper;

import java.util.List;

public class QuizViewModel extends ViewModel {

    private QuizRepository repository;

    public QuizViewModel(QuizRepository repository) {
        this.repository = repository;
        repository.loadQuizData();
    }

    public LiveData<List<Quiz>> getQuizList() {
        return repository.getQuizList();
    }

}
