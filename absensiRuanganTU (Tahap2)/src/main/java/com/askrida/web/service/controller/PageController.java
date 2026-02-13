package com.askrida.web.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.askrida.web.service.repository.RepositoryTes;
import com.askrida.web.service.model.RestResult;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PageController {

    @Autowired
    private RepositoryTes repTes;

    @GetMapping("/")
    public String dashboard(Model model) {
        List<RestResult> dataAbsensi;
        try {
            dataAbsensi = repTes.getAll();
        } catch (Exception e) {
            dataAbsensi = new ArrayList<>();
        }
        model.addAttribute("dataAbsensi", dataAbsensi);
        model.addAttribute("totalAbsensi", dataAbsensi.size());

        long hadir = dataAbsensi.stream().filter(r -> r.getWaktu_input() != null).count();
        model.addAttribute("totalHadir", hadir);
        model.addAttribute("totalRuangan", 4);
        return "dashboard";
    }

    @GetMapping("/monitoring")
    public String monitoring(Model model) {
        List<RestResult> dataAbsensi;
        try {
            dataAbsensi = repTes.getAll();
        } catch (Exception e) {
            dataAbsensi = new ArrayList<>();
        }
        model.addAttribute("dataAbsensi", dataAbsensi);
        return "dashboard";
    }

    @GetMapping("/face-register")
    public String faceRegister() {
        return "face-register";
    }

    @GetMapping("/face-absensi")
    public String faceAbsensi() {
        return "face-absensi";
    }
}
