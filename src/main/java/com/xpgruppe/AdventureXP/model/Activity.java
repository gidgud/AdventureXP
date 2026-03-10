package com.xpgruppe.AdventureXP.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "activity")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Activity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;

	private String description;

	private String requirements;

	private LocalDate startDate;

	private LocalDate endDate;

	@OneToMany(mappedBy = "activity", cascade = CascadeType.ALL)
	private List<Equipment> equipmentList;
}
