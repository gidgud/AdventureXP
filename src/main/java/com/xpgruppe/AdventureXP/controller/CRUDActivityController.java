package com.xpgruppe.AdventureXP.controller;


import com.xpgruppe.AdventureXP.mapper.CRUDActivityMapper;
import com.xpgruppe.AdventureXP.model.DTO.CRUDActivityDTO;
import com.xpgruppe.AdventureXP.model.Equipment;
import com.xpgruppe.AdventureXP.repository.EquipmentRepository;
import com.xpgruppe.AdventureXP.service.ActivityService;
import com.xpgruppe.AdventureXP.service.EquipmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/CRUD")
public class CRUDActivityController {

    private final EquipmentService equipmentService;
    private final ActivityService activityService;
    private final EquipmentRepository equipmentRepository;

    public CRUDActivityController(EquipmentService equipmentService, ActivityService activityService, EquipmentRepository equipmentRepository) {
        this.equipmentService = equipmentService;
        this.activityService = activityService;
        this.equipmentRepository = equipmentRepository;
    }

    @GetMapping("/activity/create")
    public String createActivity(Model model){
        model.addAttribute("activity", new CRUDActivityDTO());
        model.addAttribute("equipments", equipmentService.getAll());

        return "crud-activity";
    }

    @PostMapping("/activity/create")
    public String submitDetails(@ModelAttribute ("activity") CRUDActivityDTO dto){
        activityService.createActivity(CRUDActivityMapper.toEntity(dto));
        return "redirect:/activity";
    }

    @PostMapping("/activity/add-equipment")
    public String addEquipment(@ModelAttribute("activity") CRUDActivityDTO dto, Model model){

        Equipment eq = equipmentRepository.findById(dto.getSelectedEquipmentId())
                .orElseThrow();

        dto.getEquipmentList().add(eq);

        model.addAttribute("activity", dto );
        model.addAttribute("equipments", equipmentService.getAll());

        return "crud-activity";

    }



}
