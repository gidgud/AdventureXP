package com.xpgruppe.AdventureXP.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xpgruppe.AdventureXP.model.Activity;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
}
