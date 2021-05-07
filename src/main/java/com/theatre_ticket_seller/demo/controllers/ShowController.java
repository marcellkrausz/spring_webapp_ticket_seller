package com.theatre_ticket_seller.demo.controllers;

import com.theatre_ticket_seller.demo.repositories.ShowRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShowController {

    private ShowRepository showRepository;

    public ShowController(ShowRepository showRepository) {
        this.showRepository = showRepository;
    }

    @RequestMapping("/shows")
    public String getShows(Model model){
        model.addAttribute("shows", showRepository.findAll());
        return "shows";
    }
}
