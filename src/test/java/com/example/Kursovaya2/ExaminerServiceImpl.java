package com.example.Kursovaya2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ExaminerServiceImplTest {
    private QuestionService questionService;
    private ExaminerServiceImpl examinerService;

    @BeforeEach
    void setUp() {
        questionService = mock(QuestionService.class);
        examinerService = new ExaminerServiceImpl(questionService);
    }

    @Test
    void testGetQuestions() {
        // Создание мок-коллекции вопросов
        Collection<Question> mockQuestions = createMockQuestions();

        // Настройка поведения questionService
        when(questionService.getAll()).thenReturn(mockQuestions);

        // Вызов метода getQuestions с заданным количеством вопросов
        int amount = 2;
        Collection<Question> result = examinerService.getQuestions(amount);

        // Проверка, что результат не равен null и проверка размера результата
        assertNotNull(result, "Коллекция результата не должна быть null");
        assertEquals(amount, result.size(), "Размер коллекции результата должен соответствовать ожидаемому количеству вопросов");
    }


    private Collection<Question> createMockQuestions() {

        Collection<Question> mockQuestions = new ArrayList<>();
        mockQuestions.add(new Question("Mock Question 1", "Mock Answer 1"));
        mockQuestions.add(new Question("Mock Question 2", "Mock Answer 2"));

        return mockQuestions;
    }
}