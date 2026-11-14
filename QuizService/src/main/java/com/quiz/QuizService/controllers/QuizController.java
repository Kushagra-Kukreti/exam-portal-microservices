package com.quiz.QuizService.controllers;

import com.quiz.QuizService.entities.Quiz;
import com.quiz.QuizService.services.QuizService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    private QuizService quizService;
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    //create
    @PostMapping
    public Quiz addQuiz(@RequestBody Quiz quiz){
        return quizService.addQuiz(quiz);
    }

    @GetMapping("{id}")
    public Quiz getQuiz(@PathVariable Long id){
        return quizService.getQuizById(id);
    }

    @GetMapping
    public List<Quiz> getAllQuizzes(){
        return quizService.getQuizzes();
    }




}
