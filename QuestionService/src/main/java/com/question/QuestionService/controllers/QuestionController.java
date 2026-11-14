package com.question.QuestionService.controllers;

import com.question.QuestionService.entities.Question;
import com.question.QuestionService.services.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    private QuestionService questionService;

    @PostMapping
    Question addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }
    @GetMapping("{id}")
    Question getQuestionById(@PathVariable Long id){
       return questionService.getQuestionById(id);
    }
    @GetMapping
    List<Question> getQuestions(){
    return questionService.getAllQuestions();
    }

    //questions specific to a quiz
    @GetMapping("/quiz/{quizId}")
    List<Question> getQuestionsByQuizId(@PathVariable Long quizId){
        return questionService.getQuestionByQuizId(quizId);
    }

}
