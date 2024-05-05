package com.assesment.examservice.repository;

import com.assesment.examservice.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findAllByQuizId(Long quizId);

    @Modifying
    @Query("delete from Question q where q.quizId = ?1")
    void  deleteAllByQuizId(Long quizId);
}
