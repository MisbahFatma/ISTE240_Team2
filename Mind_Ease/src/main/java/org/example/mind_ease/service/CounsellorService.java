/** Assignment 3: Team Members
 * Misbah Fatma Begum : 418008089
 * Ali jouni - 769009393
 */

package org.example.mind_ease.service;

import org.example.mind_ease.model.Counsellor;
import org.example.mind_ease.repository.CounsellorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CounsellorService {

    private final CounsellorRepository counsellorRepository;

    public CounsellorService(CounsellorRepository counsellorRepository) {
        this.counsellorRepository = counsellorRepository;
    }

    public List<Counsellor> getAllCounsellors() {
        return counsellorRepository.findAll();
    }

    public Optional<Counsellor> getCounsellorById(Long id) {
        return counsellorRepository.findById(id);
    }

    public List<Counsellor> getCounsellorsBySpecialization(String specialization) {
        return counsellorRepository.findBySpecialization(specialization);
    }

    public Counsellor saveCounsellor(Counsellor counsellor) {
        return counsellorRepository.save(counsellor);
    }

    public Counsellor updateCounsellor(Long id, Counsellor updatedCounsellor) {
        return counsellorRepository.findById(id).map(counsellor -> {
            counsellor.setName(updatedCounsellor.getName());
            counsellor.setEmail(updatedCounsellor.getEmail());
            counsellor.setSpecialization(updatedCounsellor.getSpecialization());
            counsellor.setAvailability(updatedCounsellor.getAvailability());
            return counsellorRepository.save(counsellor);
        }).orElse(null);
    }

    public void deleteCounsellor(Long id) {
        counsellorRepository.deleteById(id);
    }
}