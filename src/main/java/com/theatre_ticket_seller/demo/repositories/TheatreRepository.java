package com.theatre_ticket_seller.demo.repositories;

import com.theatre_ticket_seller.demo.model.Theatre;
import org.springframework.data.repository.CrudRepository;

public interface TheatreRepository extends CrudRepository<Theatre,Long> {
}
