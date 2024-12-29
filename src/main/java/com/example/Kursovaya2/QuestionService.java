package com.example.Kursovaya2;

import java.util.Collection;

public interface QuestionService {
    Question add(String question, String answer);
    // создание нового вопроса

    Question add(Question question);
    // добавить вопрос в список вопросов

    Question remove(Question question);
    // удалить вопрос из списка вопросов

    Collection<Question> getAll();
    // получить все вопросы

    Question getRandomQuestion();

}
