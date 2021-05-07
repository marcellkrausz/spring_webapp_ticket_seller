package com.theatre_ticket_seller.demo.repositories;

import com.theatre_ticket_seller.demo.model.Show;
import org.springframework.data.repository.CrudRepository;

public interface ShowRepository extends CrudRepository<Show,Long> {
}
