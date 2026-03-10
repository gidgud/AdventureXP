package com.xpgruppe.AdventureXP.config;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.xpgruppe.AdventureXP.model.Activity;
import com.xpgruppe.AdventureXP.repository.ActivityRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {

    private final ActivityRepository activityRepository;

    @Override
    public void run(String... args) {
        if (activityRepository.count() > 0) return;

        activityRepository.saveAll(List.of(
            Activity.builder().title("Sumobrydning").description("Sjov og kaotisk kamp i sumodragter.").requirements("Minimum 18 år. Ingen rygproblemer.").startDate(LocalDate.of(2025, 6, 1)).endDate(LocalDate.of(2025, 6, 1)).build(),
            Activity.builder().title("Paintball").description("Actionfyldt holdkamp med malingkugler.").requirements("Minimum 15 år. Beskyttelsesudstyr udleveres.").startDate(LocalDate.of(2025, 6, 8)).endDate(LocalDate.of(2025, 6, 8)).build(),
            Activity.builder().title("Minigolf").description("Hyggelig og konkurrencepræget minigolf.").requirements("Ingen krav. Passer til alle aldre.").startDate(LocalDate.of(2025, 6, 15)).endDate(LocalDate.of(2025, 6, 15)).build(),
            Activity.builder().title("Wipeout").description("Forhindringsbane med fart, balance og grin.").requirements("Minimum 16 år. Sportstøj påkrævet.").startDate(LocalDate.of(2025, 6, 22)).endDate(LocalDate.of(2025, 6, 22)).build(),
            Activity.builder().title("Gokart").description("Ræs mod vennerne på gokartbanen.").requirements("Minimum 160 cm høj. Køreudstyr medfølger.").startDate(LocalDate.of(2025, 6, 29)).endDate(LocalDate.of(2025, 6, 29)).build()
        ));
    }
}
