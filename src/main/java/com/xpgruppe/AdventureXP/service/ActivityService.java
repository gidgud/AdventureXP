package com.xpgruppe.AdventureXP.service;

import org.springframework.stereotype.Service;

import com.xpgruppe.AdventureXP.model.Activity;
import com.xpgruppe.AdventureXP.repository.ActivityRepository;

@Service
public class ActivityService {

	private final ActivityRepository activityRepository;


	public ActivityService(ActivityRepository activityRepository){
		this.activityRepository = activityRepository;
	}

	public Activity getActivity(Long id) {

		Activity activity = activityRepository.findById(id).orElseThrow(() -> new RuntimeException("Activity not found with id: " + id));
		return activity;
	}


}
