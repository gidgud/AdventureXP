package com.xpgruppe.AdventureXP.controller;

import com.xpgruppe.AdventureXP.mapper.CRUDActivityMapper;
import com.xpgruppe.AdventureXP.model.DTO.CRUDActivityDTO;
import com.xpgruppe.AdventureXP.model.Activity;
import com.xpgruppe.AdventureXP.model.Equipment;
import com.xpgruppe.AdventureXP.repository.ActivityRepository;
import com.xpgruppe.AdventureXP.repository.EquipmentRepository;
import com.xpgruppe.AdventureXP.service.ActivityService;
import com.xpgruppe.AdventureXP.service.EquipmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/CRUD")
@SessionAttributes("activity")

public class CRUDActivityController {

    private final ActivityRepository activityRepository;
    private final EquipmentService equipmentService;
    private final ActivityService activityService;
    private final EquipmentRepository equipmentRepository;

    public CRUDActivityController(EquipmentService equipmentService, ActivityService activityService,
            EquipmentRepository equipmentRepository, ActivityRepository activityRepository) {
        this.equipmentService = equipmentService;
        this.activityService = activityService;
        this.equipmentRepository = equipmentRepository;
        this.activityRepository = activityRepository;
    }

    @ModelAttribute("activity")
    public CRUDActivityDTO activity() {
        return new CRUDActivityDTO();
    }

    @GetMapping("/activity/create")
    public String createActivity(Model model) {
        model.addAttribute("equipments", equipmentService.getAll());
        return "crud-activity";
    }

    @PostMapping("/activity/create")
    public String submitDetails(@ModelAttribute("activity") CRUDActivityDTO dto, String action) {

        if(action.equals("save")) {
            
        Activity activity = Activity.builder()
                .title(dto.getActivityName())
                .description(dto.getActivityDetail())
                .requirements(dto.getActivityRequimentDetail())
                .build();
                
        activityService.createActivity(activity);



        activityRepository.save(activity);
       
    

        }

        
        

        

        return "redirect:/activity/create";
    }

    @PostMapping("/activity/add-equipment")
    public String addEquipment(@ModelAttribute("activity") CRUDActivityDTO dto, Model model) {

        Long equipmentId = dto.getSelectedEquipmentId();

        Equipment eq = equipmentRepository.findById(equipmentId)
                .orElseThrow();

        if (dto.getEquipmentList().stream().noneMatch(e -> e.getId().equals(equipmentId))) {
            dto.getEquipmentList().add(eq);
        }

        System.out.println(dto.getActivityName());
        
        model.addAttribute("activity", dto);
        model.addAttribute("equipments", equipmentService.getAll());
        return "crud-activity";
    }

}
