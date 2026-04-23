package org.example.mind_ease.controller;

import org.example.mind_ease.model.Resource;
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

    // CREATE SURVEY
    @PostMapping
    public ResponseEntity<List<Resource>> createSurvey(
            @RequestParam Long studentId,
            @RequestParam int stressLevel) {

        List<Resource> resources =
                surveyService.createSurveyAndGetResources(studentId, stressLevel);

        return ResponseEntity.ok(resources);
    }

    // UPDATE SURVEY
    @PutMapping("/{id}")
    public ResponseEntity<StressSurvey> updateSurvey(
            @PathVariable Long id,
            @RequestParam int stressLevel) {

        try {
            StressSurvey updated = surveyService.updateSurvey(id, stressLevel);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE SURVEY
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSurvey(@PathVariable Long id) {
        surveyService.deleteSurvey(id);
        return ResponseEntity.noContent().build();
    }
}