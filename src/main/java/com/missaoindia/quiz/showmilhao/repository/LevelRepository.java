package com.missaoindia.quiz.showmilhao.repository;

import com.missaoindia.quiz.showmilhao.model.QuestionLevel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LevelRepository extends JpaRepository<QuestionLevel, Integer> {
}
