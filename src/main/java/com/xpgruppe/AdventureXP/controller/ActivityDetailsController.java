package com.xpgruppe.AdventureXP.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.xpgruppe.AdventureXP.model.Activity;
import com.xpgruppe.AdventureXP.service.ActivityService;
import com.xpgruppe.AdventureXP.service.EquipmentService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ActivityDetailsController {

	private final ActivityService activityService;

	private final EquipmentService equipmentService;

	@GetMapping("/activity-details")
	public String activityDetails(@RequestParam Long id, Model model) {
		Activity activity = activityService.getActivity(id);
		model.addAttribute("activity", activity);
		return "activityDetails";

	}

	@PostMapping("/equipment/{id}/status")
	public String updateStatus(@PathVariable Long id, @RequestParam String status, @RequestParam(required = false) Long activityId, RedirectAttributes redirectAttributes) {
		equipmentService.updateStatus(id, status);
		return "redirect:/activity-details?id=" + activityId;
	}

}
