/** Assignment 2: Team Members
 * Misbah Fatma Begum : 418008089
 * Yara Alhammouri - 768008964
 * Ali jouni - 769009393
 */
package org.example.mind_ease.service;

import org.example.mind_ease.model.Student;
import org.example.mind_ease.model.Resource;
import org.example.mind_ease.model.Counsellor;
import org.example.mind_ease.model.Booking;
import org.example.mind_ease.model.StressSurvey;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MindEaseService {

    private final List<Student> students = new ArrayList<>();
    private final List<Resource> resources = new ArrayList<>();
    private final List<Counsellor> counsellors = new ArrayList<>();
    private final List<Booking> bookings = new ArrayList<>();
    private final List<StressSurvey> surveys = new ArrayList<>();

    public MindEaseService() {
        // Seed some students
        students.add(new Student(1L, "Alice", "alice@example.com"));
        students.add(new Student(2L, "Bob", "bob@example.com"));

        // Seed some resources
        resources.add(new Resource(1, "Mindfulness Video", "Video", "Calm your mind", "https://video.com", "Low"));
        resources.add(new Resource(2, "Stress Game", "Game", "Fun way to reduce stress", "https://game.com", "Medium"));

        // Seed some counsellors
        counsellors.add(new Counsellor(1L, "Dr. Smith", "Mental Health", "smith@example.com", "Mon-Fri"));
        counsellors.add(new Counsellor(2L, "Dr. Jane", "Stress Management", "jane@example.com", "Tue-Thu"));

        // Seed some surveys and link to students
        surveys.add(new StressSurvey(1L, students.get(0), 3, "2026-03-01"));
        surveys.add(new StressSurvey(2L, students.get(1), 4, "2026-03-02"));
        students.get(0).getSurveys().add(surveys.get(0));
        students.get(1).getSurveys().add(surveys.get(1));

        // Optional: Seed some bookings and link to students & counsellors
        Booking b1 = new Booking(students.get(0), counsellors.get(0), "2026-03-15T14:30");
        Booking b2 = new Booking(students.get(1), counsellors.get(1), "2026-03-16T10:00");
        addBooking(b1);
        addBooking(b2);
    }

    // Students
    public List<Student> getStudents() { return students; }
    public void addStudent(Student student) { students.add(student); }

    // Resources
    public List<Resource> getResources() { return resources; }
    public void addResource(Resource resource) { resources.add(resource); }

    // Counsellors
    public List<Counsellor> getCounsellors() { return counsellors; }
    public void addCounsellor(Counsellor counsellor) { counsellors.add(counsellor); }

    // Bookings
    public List<Booking> getBookings() { return bookings; }
    public void addBooking(Booking booking) {
        bookings.add(booking);
        // link booking to student and counsellor
        booking.getStudent().getBookings().add(booking);
        booking.getCounsellor().getBookings().add(booking);
    }

    // Stress Surveys
    public List<StressSurvey> getSurveys() { return surveys; }
    public void addSurvey(StressSurvey survey) { surveys.add(survey); }
}