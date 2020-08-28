package com.example.triviaquiz.data.network.model;

import com.squareup.moshi.Json;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Quiz {
    String question;
    @Json(name= "correct_answer")
    String correctAnswer;
    @Json(name= "incorrect_answers")
    List<String> inCorrectAnswers;

    public Quiz(String question, String correctAnswer, List<String> inCorrectAnswers) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.inCorrectAnswers = inCorrectAnswers;
    }

    public String getQuestion() {
        return question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public List<String> getInCorrectAnswers() {
        return inCorrectAnswers;
    }

    public List<String> getAnswers() {
        ArrayList<String> answers = new ArrayList<>();
        answers.add(correctAnswer);
        for (String ans : inCorrectAnswers) {
            answers.add(ans);
        }
        Collections.sort(answers);
        return answers;
    }
}
