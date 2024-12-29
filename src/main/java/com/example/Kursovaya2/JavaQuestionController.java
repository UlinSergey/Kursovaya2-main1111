package com.example.Kursovaya2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;


@RequestMapping
@RestController
public class JavaQuestionController {
    QuestionService service;

    public JavaQuestionController(QuestionService service) {
        this.service = service;
    }

    @GetMapping(path = "/add")
    Question addQuestion(@RequestParam("question") String question, @RequestParam("answer") String answer) {
        return service.add(question, answer);
    }

    @GetMapping(path = "")
    Collection<Question> getQuestions() {
        return service.getAll();
    }

    @GetMapping(path = "/remove")
    Question removeQuestion(@RequestParam("question") String question, @RequestParam("answer") String answer) {
        Question questionToRemove = new Question(question, answer);
        return service.remove(questionToRemove);
    }
}


