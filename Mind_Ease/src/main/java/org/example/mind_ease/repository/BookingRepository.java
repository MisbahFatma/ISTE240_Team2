/** Assignment 3: Team Members
 * Misbah Fatma Begum : 418008089
 * Ali jouni - 769009393
 */

package org.example.mind_ease.repository;

import org.example.mind_ease.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByStatus(String status);

}