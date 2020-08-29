package com.example.triviaquiz.data.database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity(tableName = "quiz_data")
public class LocalQuiz {

    @PrimaryKey
    Integer id = 1;
    Integer score = 0;
    String question;
    String correctAnswer;
    String inCorrectAnswer1;
    String inCorrectAnswer2;
    String inCorrectAnswer3;
    String inCorrectAnswer4;
    String userAnswer;

    public LocalQuiz(Integer id, Integer score, String question, String correctAnswer, String inCorrectAnswer1, String inCorrectAnswer2, String inCorrectAnswer3, String inCorrectAnswer4, String userAnswer) {
        this.id = id;
        this.score = score;
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.inCorrectAnswer1 = inCorrectAnswer1;
        this.inCorrectAnswer2 = inCorrectAnswer2;
        this.inCorrectAnswer3 = inCorrectAnswer3;
        this.inCorrectAnswer4 = inCorrectAnswer4;
        this.userAnswer = userAnswer;
    }

    public Integer getId() {
        return id;
    }

    public Integer getScore() {
        return score;
    }

    public String getQuestion() {
        return question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public String getInCorrectAnswer1() {
        return inCorrectAnswer1;
    }

    public String getInCorrectAnswer2() {
        return inCorrectAnswer2;
    }

    public String getInCorrectAnswer3() {
        return inCorrectAnswer3;
    }

    public String getInCorrectAnswer4() {
        return inCorrectAnswer4;
    }

    public String getUserAnswer() {
        return userAnswer;
    }

    public List<String> getAnswers() {
        ArrayList<String> answers = new ArrayList<>();
        answers.add(correctAnswer);
        answers.add(inCorrectAnswer1);
        if (inCorrectAnswer2 != null) {
            answers.add(inCorrectAnswer2);
        }
        if (inCorrectAnswer3 != null) {
            answers.add(inCorrectAnswer3);
        }
        if (inCorrectAnswer4 != null) {
            answers.add(inCorrectAnswer4);
        }

        Collections.sort(answers);
        return answers;
    }

}
