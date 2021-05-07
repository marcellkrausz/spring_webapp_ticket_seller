package com.theatre_ticket_seller.demo.controllers;

import com.theatre_ticket_seller.demo.repositories.TheatreRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TheatreController {

    private TheatreRepository theatreRepository;

    public TheatreController(TheatreRepository theatreRepository) {
        this.theatreRepository = theatreRepository;
    }

    @RequestMapping("/theatres")
    public String getTheatres(Model model) {
        model.addAttribute("theatres", theatreRepository.findAll());
        return "theatres";
    }
}
