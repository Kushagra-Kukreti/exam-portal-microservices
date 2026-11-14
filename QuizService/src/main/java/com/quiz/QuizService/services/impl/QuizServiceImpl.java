package com.quiz.QuizService.services.impl;

import com.quiz.QuizService.entities.Quiz;
import com.quiz.QuizService.repositories.QuizRepository;
import com.quiz.QuizService.services.QuestionClient;
import com.quiz.QuizService.services.QuizService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

// ye service taaki isko autowire kr ske kahi bhi
@Service
public class QuizServiceImpl implements QuizService {

    //repo ka access chahiyeh
    private QuizRepository quizRepo;

    public QuizServiceImpl(QuestionClient questionClient, QuizRepository quizRepo) {
        this.questionClient = questionClient;
        this.quizRepo = quizRepo;
    }

    private QuestionClient questionClient;


    @Override
    public Quiz addQuiz(Quiz quiz) {
         return quizRepo.save(quiz);
    }

    @Override
    public List<Quiz> getQuizzes() {
        List<Quiz> quizzes =  quizRepo.findAll();
        List<Quiz> newList = quizzes.stream().map(quiz->{
            quiz.setQuestions(questionClient.getAllQuestionsByQuizId(quiz.getId()));
            return quiz;
        }).collect(Collectors.toList());
        return newList;
    }

    @Override
    public Quiz getQuizById(Long id) {
        Quiz quiz =  quizRepo.findById(id).orElseThrow(()->new RuntimeException("Invalid Quiz Id"));
        quiz.setQuestions(questionClient.getAllQuestionsByQuizId(quiz.getId()));
        return quiz;
    }
}
