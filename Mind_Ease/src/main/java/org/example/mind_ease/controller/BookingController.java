/** Assignment 2: Team Members
 * Misbah Fatma Begum : 418008089
 * Yara Alhammouri - 768008964
 * Ali jouni - 769009393
 */
package org.example.mind_ease.controller;

import org.example.mind_ease.model.Booking;
import org.example.mind_ease.model.Counsellor;
import org.example.mind_ease.model.Student;
import org.example.mind_ease.service.MindEaseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookingController {

    private final MindEaseService service;

    public BookingController(MindEaseService service) {
        this.service = service;
    }

    // Display all bookings
    @GetMapping("/bookings")
    public String showBookings(Model model) {
        model.addAttribute("bookings", service.getBookings()); // <-- fixed name
        return "booking"; // matches booking.html
    }

    // Show form to add a booking
    @GetMapping("/bookings/add")
    public String showAddBookingForm(Model model) {
        model.addAttribute("students", service.getStudents());
        model.addAttribute("counsellors", service.getCounsellors());
        return "add-booking";
    }

    // Handle form submission
    @PostMapping("/bookings/add")
    public String addBooking(@RequestParam Long studentId,
                             @RequestParam Long counsellorId,
                             @RequestParam String dateTime) {

        Student student = service.getStudents().stream()
                .filter(s -> s.getId().equals(studentId))
                .findFirst().orElse(null);

        Counsellor counsellor = service.getCounsellors().stream()
                .filter(c -> c.getId().equals(counsellorId))
                .findFirst().orElse(null);

        if(student != null && counsellor != null) {
            Booking booking = new Booking(student, counsellor, dateTime);
            service.addBooking(booking);
        }

        return "redirect:/add/success/booking";
    }
}