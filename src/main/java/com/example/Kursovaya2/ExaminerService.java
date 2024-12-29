package com.example.Kursovaya2;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
