package com.assesment.examservice.repository;

import com.assesment.examservice.entity.ExamResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExamResultRepo extends JpaRepository<ExamResult, Long> {
    List<ExamResult> findByUserId(Long userId);
}
