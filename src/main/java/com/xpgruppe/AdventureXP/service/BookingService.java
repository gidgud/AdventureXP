package com.xpgruppe.AdventureXP.service;

import com.xpgruppe.AdventureXP.model.Booking;
import com.xpgruppe.AdventureXP.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public Booking getBookingById(Long id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
        return booking;
    }

    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public Booking updateBooking(Long id, Booking updatedBooking) {
        Booking existingBooking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        existingBooking.setCustomerName(updatedBooking.getCustomerName());
        existingBooking.setCustomerEmail(updatedBooking.getCustomerEmail());
        existingBooking.setBookingDate(updatedBooking.getBookingDate());
        existingBooking.setStartTime(updatedBooking.getStartTime());
        existingBooking.setEndTime(updatedBooking.getEndTime());
        existingBooking.setNumberOfPeople(updatedBooking.getNumberOfPeople());
        existingBooking.setActivity(updatedBooking.getActivity());

        return bookingRepository.save(existingBooking);
    }

    public void deleteBooking(Long id) {
        Booking existingBooking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
        bookingRepository.delete(existingBooking);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }
}