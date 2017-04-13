package com.cgi.dentistapp.controller;

import com.cgi.dentistapp.dao.entity.VisitEntity;
import com.cgi.dentistapp.dto.VisitDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.cgi.dentistapp.service.VisitService;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
@EnableAutoConfiguration
public class DentistAppController extends WebMvcConfigurerAdapter {

    @Autowired
    private VisitService visitService;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
    }

    @GetMapping("/")
    public String showRegisterForm(VisitDTO visitDTO, Model model) {
        List<String> gps = Arrays.asList("H. Mets", "K. Apsas", "M. Elo Nid");
        model.addAttribute("gps", gps);
        return "form";
    }

    @GetMapping("/calendar")
    public String showCalendar(VisitDTO visitDTO, Model model) {
        List<VisitEntity> registrations = visitService.listVisits();
        model.addAttribute("regs", registrations);
        return "calendar";
    }

    @PostMapping("/")
    public String postRegisterForm(@Valid VisitDTO visitDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "form";
        }

        visitService.addVisit(visitDTO.getDentistName(), visitDTO.getDentistVisitTime(), visitDTO.getGpName(), visitDTO.getGpVisitTime());
        return "redirect:/results";
    }

}
