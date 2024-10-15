package com.istidata.data_pribadi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.istidata.data_pribadi.model.Karyawan;
import com.istidata.data_pribadi.service.KaryawanService;

@Controller
@RequestMapping("")
public class KaryawanController {
      @Autowired
    private KaryawanService karyawanService;

    @GetMapping
    public String listKaryawan(Model model) {
        List<Karyawan> karyawanList = karyawanService.getAllKaryawan();
        model.addAttribute("karyawanList", karyawanList);
        return "index";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("karyawan", new Karyawan());
        return "add";
    }

    @PostMapping("/save")
    public String saveKaryawan(@ModelAttribute("karyawan") Karyawan karyawan) {
        karyawanService.saveKaryawan(karyawan);
        return "redirect:/";
    }

    @GetMapping("/edit/{nik}")
    public String showEditForm(@PathVariable Long nik, Model model) {
        Karyawan karyawan = karyawanService.getKaryawanById(nik);
        model.addAttribute("karyawan", karyawan);
        return "edit";
    }

    @PostMapping("/update/{nik}")
    public String updateKaryawan(@PathVariable Long nik, @ModelAttribute("karyawan") Karyawan karyawan) {
        karyawan.setNik(nik);
        karyawanService.saveKaryawan(karyawan);
        return "redirect:/";
    }

    @GetMapping("/delete/{nik}")
    public String deleteKaryawan(@PathVariable Long nik) {
        karyawanService.deleteKaryawan(nik);
        return "redirect:/";
    }
}
