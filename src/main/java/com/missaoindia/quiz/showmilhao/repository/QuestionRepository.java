package com.missaoindia.quiz.showmilhao.repository;

import com.missaoindia.quiz.showmilhao.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    Question findByLevel(Integer level);

    List<Question> findByLevelAndActive(Integer level, Boolean active);

    List<Question> findAllByLevel(Integer level);
}
