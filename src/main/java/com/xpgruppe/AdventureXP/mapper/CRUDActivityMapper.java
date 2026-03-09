package com.xpgruppe.AdventureXP.mapper;

import com.xpgruppe.AdventureXP.model.Activity;
import com.xpgruppe.AdventureXP.model.DTO.CRUDActivityDTO;

public class CRUDActivityMapper {

    public static Activity toEntity(CRUDActivityDTO dto){
        Activity activity = new Activity();
        activity.setTitle(dto.getActivityName());
        activity.setDescription(dto.getActivityDetail());
        activity.setRequirements(dto.getActivityRequimentDetail());
        activity.setEquipmentList(dto.getEquipments());

        return activity;
    }
}
