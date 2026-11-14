package com.quiz.QuizService.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quiz-test")
public class QuizTestController {
    String getQuizTest(){
        return "This is quiz test";
    }
}
