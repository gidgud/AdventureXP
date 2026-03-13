package com.xpgruppe.AdventureXP.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "equipment")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "activity_id")
    @JsonIgnore
    private Activity activity;

	@Enumerated(EnumType.STRING)
	private EquipmentStatus status;

}