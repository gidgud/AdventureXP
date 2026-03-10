package com.xpgruppe.AdventureXP.service;

import java.util.ArrayList;
import java.util.List;

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

	public Activity createActivity(Activity activity) {
		return activityRepository.save(activity);
	}

	public Activity updateActivity(Long id, Activity updatedActivity) {

		Activity existingActivity = activityRepository.findById(id).orElseThrow(() -> new RuntimeException("Activity not found with id: " + id));

		existingActivity.setTitle(updatedActivity.getTitle());
		existingActivity.setDescription(updatedActivity.getDescription());
		existingActivity.setStartDate(updatedActivity.getStartDate());
		existingActivity.setEndDate(updatedActivity.getEndDate());
		return activityRepository.save(existingActivity);
	}

	public void deleteActivity(Long id) {
		Activity existingActivity = activityRepository.findById(id).orElseThrow(() -> new RuntimeException("Activity not found with id: " + id));
		activityRepository.delete(existingActivity);
	}

	public List<Activity> getAllActivitys() {
		return activityRepository.findAll();
	}


}
