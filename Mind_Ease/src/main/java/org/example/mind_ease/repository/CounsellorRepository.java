/** Assignment 3: Team Members
 * Misbah Fatma Begum : 418008089
 * Ali jouni - 769009393
 */

package org.example.mind_ease.repository;

import org.example.mind_ease.model.Counsellor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CounsellorRepository extends JpaRepository<Counsellor, Long> {

    List<Counsellor> findBySpecialization(String specialization);

}