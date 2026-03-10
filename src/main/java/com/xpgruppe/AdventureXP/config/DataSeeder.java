package com.xpgruppe.AdventureXP.config;

import com.xpgruppe.AdventureXP.model.Activity;
import com.xpgruppe.AdventureXP.model.Equipment;
import com.xpgruppe.AdventureXP.model.EquipmentStatus;
import com.xpgruppe.AdventureXP.repository.ActivityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {

    private final ActivityRepository activityRepository;

    @Override
    public void run(String... args) {
        if (activityRepository.count() > 0) return;

        Activity sumo = Activity.builder()
                .title("Sumobrydning")
                .description("Sjov og kaotisk kamp i sumodragter.")
                .requirements("Minimum 18 år. Ingen rygproblemer.")
                .startDate(LocalDate.of(2025, 6, 1))
                .endDate(LocalDate.of(2025, 6, 1))
                .build();
        sumo.setEquipmentList(List.of(
                Equipment.builder().name("Sumodragt (stor)").status(EquipmentStatus.TILGÆNGELIG).activity(sumo).build(),
                Equipment.builder().name("Sumodragt (lille)").status(EquipmentStatus.TILGÆNGELIG).activity(sumo).build(),
                Equipment.builder().name("Oppustelig bane").status(EquipmentStatus.TILGÆNGELIG).activity(sumo).build()
        ));

        Activity paintball = Activity.builder()
                .title("Paintball")
                .description("Actionfyldt holdkamp med malingkugler.")
                .requirements("Minimum 15 år. Beskyttelsesudstyr udleveres.")
                .startDate(LocalDate.of(2025, 6, 8))
                .endDate(LocalDate.of(2025, 6, 8))
                .build();
        paintball.setEquipmentList(List.of(
                Equipment.builder().name("Paintballmarkør").status(EquipmentStatus.TILGÆNGELIG).activity(paintball).build(),
                Equipment.builder().name("Beskyttelsesmaske").status(EquipmentStatus.TILGÆNGELIG).activity(paintball).build(),
                Equipment.builder().name("Beskyttelsesvest").status(EquipmentStatus.TILGÆNGELIG).activity(paintball).build(),
                Equipment.builder().name("Malingkugler (500 stk)").status(EquipmentStatus.TILGÆNGELIG).activity(paintball).build()
        ));

        Activity minigolf = Activity.builder()
                .title("Minigolf")
                .description("Hyggelig og konkurrencepræget minigolf.")
                .requirements("Ingen krav. Passer til alle aldre.")
                .startDate(LocalDate.of(2025, 6, 15))
                .endDate(LocalDate.of(2025, 6, 15))
                .build();
        minigolf.setEquipmentList(List.of(
                Equipment.builder().name("Golfkølle").status(EquipmentStatus.TILGÆNGELIG).activity(minigolf).build(),
                Equipment.builder().name("Golfbold").status(EquipmentStatus.TILGÆNGELIG).activity(minigolf).build(),
                Equipment.builder().name("Scorecard").status(EquipmentStatus.TILGÆNGELIG).activity(minigolf).build()
        ));

        Activity wipeout = Activity.builder()
                .title("Wipeout")
                .description("Forhindringsbane med fart, balance og grin.")
                .requirements("Minimum 16 år. Sportstøj påkrævet.")
                .startDate(LocalDate.of(2025, 6, 22))
                .endDate(LocalDate.of(2025, 6, 22))
                .build();
        wipeout.setEquipmentList(List.of(
                Equipment.builder().name("Hjelm").status(EquipmentStatus.TILGÆNGELIG).activity(wipeout).build(),
                Equipment.builder().name("Knæbeskyttere").status(EquipmentStatus.TILGÆNGELIG).activity(wipeout).build(),
                Equipment.builder().name("Albuebeskyttere").status(EquipmentStatus.TILGÆNGELIG).activity(wipeout).build(),
                Equipment.builder().name("Oppustelig forhindring").status(EquipmentStatus.TILGÆNGELIG).activity(wipeout).build()
        ));

        Activity gokart = Activity.builder()
                .title("Gokart")
                .description("Ræs mod vennerne på gokartbanen.")
                .requirements("Minimum 160 cm høj. Køreudstyr medfølger.")
                .startDate(LocalDate.of(2025, 6, 29))
                .endDate(LocalDate.of(2025, 6, 29))
                .build();
        gokart.setEquipmentList(List.of(
                Equipment.builder().name("Gokart").status(EquipmentStatus.TILGÆNGELIG).activity(gokart).build(),
                Equipment.builder().name("Racerhjelm").status(EquipmentStatus.TILGÆNGELIG).activity(gokart).build(),
                Equipment.builder().name("Racerdragt").status(EquipmentStatus.TILGÆNGELIG).activity(gokart).build(),
                Equipment.builder().name("Handsker").status(EquipmentStatus.TILGÆNGELIG).activity(gokart).build()
        ));

        activityRepository.saveAll(List.of(sumo, paintball, minigolf, wipeout, gokart));
    }
}
