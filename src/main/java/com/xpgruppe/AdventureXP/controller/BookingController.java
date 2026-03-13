package com.xpgruppe.AdventureXP.controller;

import com.xpgruppe.AdventureXP.model.Booking;
import com.xpgruppe.AdventureXP.service.ActivityService;
import com.xpgruppe.AdventureXP.service.BookingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService bookingService;
    private final ActivityService activityService;

    public BookingController(BookingService bookingService, ActivityService activityService) {
        this.bookingService = bookingService;
        this.activityService = activityService;
    }

    @GetMapping
    public String getAllBookings(Model model) {
        model.addAttribute("bookings", bookingService.getAllBookings());
        return "bookingList";
    }

    @GetMapping("/create")
    public String showCreateBookingForm(Model model) {
        model.addAttribute("booking", new Booking());
        model.addAttribute("activities", activityService.getAllActivitys());
        return "booking";
    }

    @PostMapping("/create")
    public String createBooking(@ModelAttribute Booking booking, @RequestParam Long activityId) {
        booking.setActivity(activityService.getActivity(activityId));
        bookingService.createBooking(booking);
        return "redirect:/bookings";
    }

    @GetMapping("/delete/{id}")
    public String deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
        return "redirect:/bookings";
    }
}