package com.theatre_ticket_seller.demo.repositories;

import com.theatre_ticket_seller.demo.model.Ticket;
import org.springframework.data.repository.CrudRepository;

public interface TicketRepository extends CrudRepository<Ticket,Long> {
}
