package com.xpgruppe.AdventureXP.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.xpgruppe.AdventureXP.model.Equipment;


public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
}