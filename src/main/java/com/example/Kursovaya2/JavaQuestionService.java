package com.example.Kursovaya2;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class JavaQuestionService implements QuestionService{
    Set<Question> questions;
    public JavaQuestionService() {
        this.questions = new HashSet<Question>();
    }

    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question,answer);
        questions.add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        int randomID = random.nextInt(questions.size() + 1);
        return (Question) questions.toArray()[randomID];
    }
}
