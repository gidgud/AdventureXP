package com.xpgruppe.AdventureXP.repository;

import com.xpgruppe.AdventureXP.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}