package org.example.mind_ease.repository;

import org.example.mind_ease.model.StressSurvey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StressSurveyRepository extends JpaRepository<StressSurvey, Long> {

    List<StressSurvey> findByStudentId(Long studentId);
}
