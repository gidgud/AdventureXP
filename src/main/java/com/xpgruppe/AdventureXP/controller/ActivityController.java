package com.xpgruppe.AdventureXP.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.xpgruppe.AdventureXP.model.Activity;
import com.xpgruppe.AdventureXP.service.ActivityService;

@Controller
@RequestMapping("/activities")
public class ActivityController {

	private final ActivityService activityService;

	public ActivityController(ActivityService activityService) {
		this.activityService = activityService;
	}

	@GetMapping
	public String getActivitys(Model model) {
		List<Activity> activities = activityService.getAllActivitys();
		model.addAttribute("activities", activities);

		return "catalogue";
		
	}

	@GetMapping("/create")
	public String showCreateForm(Model model) {
		Activity activity = new Activity();
		model.addAttribute("activity", activity);
		return "create-activity";
	}

	@PostMapping("/create")
	public String createActivity(@ModelAttribute Activity activity, RedirectAttributes redirectAttributes) {

		activityService.createActivity(activity);
		redirectAttributes.addFlashAttribute("successMessage", "Activity created successfully!");
		return "redirect:/";
	}
}
