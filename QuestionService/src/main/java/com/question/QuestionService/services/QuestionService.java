package com.question.QuestionService.services;

import com.question.QuestionService.entities.Question;

import java.util.List;

public interface QuestionService {
    Question addQuestion(Question question);

    Question getQuestionById(Long id);
    List<Question> getAllQuestions();

    List<Question> getQuestionByQuizId(Long quizId);
}
