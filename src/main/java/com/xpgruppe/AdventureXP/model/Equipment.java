package com.xpgruppe.AdventureXP.model;

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

    private String status;

    @ManyToOne
    @JoinColumn(name = "activity_id")
    private Activity activity;

}