package com.example.triviaquiz.ui.quiz;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.triviaquiz.data.QuizRepository;
import com.example.triviaquiz.data.database.LocalQuiz;

import java.util.List;

public class QuizViewModel extends ViewModel {

    private QuizRepository repository;

    public QuizViewModel(QuizRepository repository) {
        this.repository = repository;
        repository.loadQuizData();
    }

    public LiveData<List<LocalQuiz>> getQuizList() {
        return repository.getQuizList();
    }

    public void isAnsCorrect(LocalQuiz quiz, String ans) {

        LocalQuiz afterResponse = new LocalQuiz(quiz.getId()
                ,quiz.getQuestion()
                ,quiz.getCorrectAnswer()
                ,quiz.getIncorrectAnswers()
                ,(quiz.getScore())
                ,ans);
        repository.updateAns(afterResponse);

        if (quiz.getCorrectAnswer().equals(ans)) {
            repository.isAnsCorrect();
        }
    }

}
