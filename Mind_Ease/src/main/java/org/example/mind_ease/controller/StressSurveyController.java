package org.example.mind_ease.controller;

import org.example.mind_ease.model.StressSurvey;
import org.example.mind_ease.service.StressSurveyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/surveys")
@CrossOrigin(origins = "*")
public class StressSurveyController {

    private final StressSurveyService surveyService;

    public StressSurveyController(StressSurveyService surveyService) {
        this.surveyService = surveyService;
    }

    // GET ALL
    @GetMapping
    public ResponseEntity<List<StressSurvey>> getAllSurveys() {
        return ResponseEntity.ok(surveyService.getAllSurveys());
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<StressSurvey> getSurveyById(@PathVariable Long id) {
        return surveyService.getSurveyById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // GET BY STUDENT
    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<StressSurvey>> getByStudent(@PathVariable Long studentId) {
        return ResponseEntity.ok(surveyService.getSurveysByStudent(studentId));
    }

    // CREATE SURVEY (FIXED)
    @PostMapping
    public ResponseEntity<StressSurvey> createSurvey(
            @RequestParam Long studentId,
            @RequestParam int stressLevel) {

        StressSurvey survey = surveyService.createSurvey(studentId, stressLevel);
        return ResponseEntity.ok(survey);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<StressSurvey> updateSurvey(
            @PathVariable Long id,
            @RequestParam int stressLevel) {

        try {
            return ResponseEntity.ok(surveyService.updateSurvey(id, stressLevel));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSurvey(@PathVariable Long id) {
        surveyService.deleteSurvey(id);
        return ResponseEntity.noContent().build();
    }
}