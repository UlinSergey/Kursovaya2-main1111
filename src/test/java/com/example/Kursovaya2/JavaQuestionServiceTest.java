package com.example.Kursovaya2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class JavaQuestionServiceTest {
    private JavaQuestionService questionService;

    @BeforeEach
    void setUp() {
        questionService = new JavaQuestionService();
    }

    @Test
    void testAddAndGetAll() {
        Question question = new Question("Сколько будет 1+1", "2");
        questionService.add(question);
        Collection<Question> allQuestions = questionService.getAll();
        assertTrue(allQuestions.contains(question));
    }

    @Test
    void testRemove() {
        Question question = new Question("Столица Фрации?", "Париж");
        questionService.add(question);
        questionService.remove(question);
        Collection<Question> allQuestions = questionService.getAll();
        assertFalse(allQuestions.contains(question));
    }

    @Test
    void testGetRandomQuestion() {
        Question q1 = new Question("Q1", "A1");
        Question q2 = new Question("Q2", "A2");

        questionService.add(q1);
        questionService.add(q2);

        Set<Question> allQuestions = new HashSet<>(questionService.getAll());

        Question randomQuestion = questionService.getRandomQuestion();
        assertTrue(allQuestions.contains(randomQuestion));
    }
}