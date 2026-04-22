/** Assignment 3: Team Members
 * Misbah Fatma Begum : 418008089
 * Ali jouni - 769009393
 */
package org.example.mind_ease.controller;

import org.example.mind_ease.model.Counsellor;
import org.example.mind_ease.service.CounsellorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/counsellors")
@CrossOrigin(origins = "*")
public class CounsellorController {

    private final CounsellorService counsellorService;

    public CounsellorController(CounsellorService counsellorService) {
        this.counsellorService = counsellorService;
    }

    // GET ALL COUNSELLORS
    @GetMapping
    public ResponseEntity<List<Counsellor>> getAllCounsellors() {
        return ResponseEntity.ok(counsellorService.getAllCounsellors());
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Counsellor> getCounsellorById(@PathVariable Long id) {
        return counsellorService.getCounsellorById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // SEARCH BY SPECIALIZATION
    @GetMapping("/search")
    public ResponseEntity<List<Counsellor>> getCounsellorsBySpecialization(
            @RequestParam String specialization) {

        return ResponseEntity.ok(
                counsellorService.getCounsellorsBySpecialization(specialization)
        );
    }

    // CREATE COUNSELLOR
    @PostMapping
    public ResponseEntity<Counsellor> createCounsellor(@RequestBody Counsellor counsellor) {
        return ResponseEntity.ok(counsellorService.saveCounsellor(counsellor));
    }

    // UPDATE COUNSELLOR
    @PutMapping("/{id}")
    public ResponseEntity<Counsellor> updateCounsellor(
            @PathVariable Long id,
            @RequestBody Counsellor counsellor) {

        Counsellor updated = counsellorService.updateCounsellor(id, counsellor);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }

    // DELETE COUNSELLOR
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCounsellor(@PathVariable Long id) {
        counsellorService.deleteCounsellor(id);
        return ResponseEntity.noContent().build();
    }
}