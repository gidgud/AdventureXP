package com.xpgruppe.AdventureXP.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Top10Controller {

    @GetMapping("/top10")
    public String top10() {
        return "top10";
    }
}
