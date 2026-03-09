package com.xpgruppe.AdventureXP.model.DTO;

import com.xpgruppe.AdventureXP.model.Equipment;
import lombok.*;

import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CRUDActivityDTO {

    private Long id;
    private String activityName;
    private String activityDetail;
    private String activityRequimentDetail;
    private ArrayList<Equipment> equipments;


}
