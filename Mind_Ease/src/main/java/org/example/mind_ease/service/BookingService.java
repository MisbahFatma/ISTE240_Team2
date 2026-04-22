/** Assignment 3: Team Members
 * Misbah Fatma Begum : 418008089
 * Ali jouni - 769009393
 */

package org.example.mind_ease.service;

import org.example.mind_ease.model.Booking;
import org.example.mind_ease.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Optional<Booking> getBookingById(Long id) {
        return bookingRepository.findById(id);
    }

    public List<Booking> getBookingsByStatus(String status) {
        return bookingRepository.findByStatus(status);
    }

    public Booking saveBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public Booking updateBooking(Long id, Booking updatedBooking) {
        return bookingRepository.findById(id).map(booking -> {
            booking.setStudent(updatedBooking.getStudent());
            booking.setCounsellor(updatedBooking.getCounsellor());
            booking.setDateTime(updatedBooking.getDateTime());
            booking.setStatus(updatedBooking.getStatus());
            return bookingRepository.save(booking);
        }).orElse(null);
    }

    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }
}