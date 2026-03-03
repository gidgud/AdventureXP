package com.xpgruppe.AdventureXP.service;

import org.springframework.stereotype.Service;
import com.xpgruppe.AdventureXP.model.Equipment;
import com.xpgruppe.AdventureXP.repository.EquipmentRepository;


@Service
public class EquipmentService {

    private final EquipmentRepository equipmentRepository;
    public EquipmentService(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }

    public Equipment getEquipment(Long id) {
        Equipment equipment = equipmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Equipment not found with id: " + id));
        return equipment;
    }  

    public Equipment createEquipment(Equipment equipment) {
        return equipmentRepository.save(equipment);
    }

    public Equipment updateEquipment(Long id, Equipment updatedEquipment) {
        Equipment existingEquipment = equipmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Equipment not found with id: " + id));

        existingEquipment.setName(updatedEquipment.getName());
        existingEquipment.setStatus(updatedEquipment.getStatus());
        return equipmentRepository.save(existingEquipment);
    }

    public void deleteEquipment(Long id) {
        Equipment existingEquipment = equipmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Equipment not found with id: " + id));
        equipmentRepository.delete(existingEquipment);
    }

}