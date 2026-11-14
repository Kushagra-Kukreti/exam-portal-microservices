package com.quiz.QuizService.repositories;

import com.quiz.QuizService.entities.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;


//implementation class apne app bn jayegi iski ab
// ab db operations kr paayenge saare
public interface QuizRepository extends JpaRepository<Quiz,Long> {
}
