package com.theatre_ticket_seller.demo.controllers;

import com.theatre_ticket_seller.demo.repositories.TicketRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TicketController {

    private TicketRepository ticketRepository;

    public TicketController(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @RequestMapping("/tickets")
    public String getTickets(Model model) {
        model.addAttribute("tickets",ticketRepository.findAll());
        return "tickets";
    }
}
