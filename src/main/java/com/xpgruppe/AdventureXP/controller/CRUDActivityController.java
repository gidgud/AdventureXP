package com.xpgruppe.AdventureXP.controller;


import com.xpgruppe.AdventureXP.mapper.CRUDActivityMapper;
import com.xpgruppe.AdventureXP.model.DTO.CRUDActivityDTO;
import com.xpgruppe.AdventureXP.service.ActivityService;
import com.xpgruppe.AdventureXP.service.EquipmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/CRUD")
public class CRUDActivityController {

    private final EquipmentService equipmentService;
    private final ActivityService activityService;

    public CRUDActivityController(EquipmentService equipmentService, ActivityService activityService) {
        this.equipmentService = equipmentService;
        this.activityService = activityService;
    }

    @GetMapping("/activity/create")
    public String createActivity(Model model){
        model.addAttribute("activity", new CRUDActivityDTO());
        model.addAttribute("equipment", equipmentService.getAll());

        return "crud-activity";
    }

    @PostMapping("/activity/create")
    public String submitDetails(@ModelAttribute ("activity") CRUDActivityDTO dto){
        activityService.createActivity(CRUDActivityMapper.toEntity(dto));
        return "redirect:/activity";
    }

}
