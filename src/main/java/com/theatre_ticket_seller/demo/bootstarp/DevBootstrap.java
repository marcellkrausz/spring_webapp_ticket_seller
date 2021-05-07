package com.theatre_ticket_seller.demo.bootstarp;

import com.theatre_ticket_seller.demo.model.Show;
import com.theatre_ticket_seller.demo.model.Theatre;
import com.theatre_ticket_seller.demo.model.Ticket;
import com.theatre_ticket_seller.demo.repositories.ShowRepository;
import com.theatre_ticket_seller.demo.repositories.TheatreRepository;
import com.theatre_ticket_seller.demo.repositories.TicketRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private ShowRepository showRepository;
    private TheatreRepository theatreRepository;
    private TicketRepository ticketRepository;

    public DevBootstrap(ShowRepository showRepository, TheatreRepository theatreRepository, TicketRepository ticketRepository) {
        this.showRepository = showRepository;
        this.theatreRepository = theatreRepository;
        this.ticketRepository = ticketRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        Theatre nemzeti = new Theatre("Nemzeti Színház","Budapest");
        theatreRepository.save(nemzeti);
        Theatre csokonai = new Theatre("Csokonai","Debrecen");
        theatreRepository.save(csokonai);

        Show palUtcaiFiuk = new Show("Pál utcai fiúk",new Date(2021-5-21),"dafa",nemzeti);
        showRepository.save(palUtcaiFiuk);
        Show show = new Show("show",new Date(2021-06-21),"dadad",csokonai);
        showRepository.save(show);

        ticketRepository.save(new Ticket(1,1,5000,palUtcaiFiuk));
        ticketRepository.save(new Ticket(1,2,5000,palUtcaiFiuk));
        for (int i = 0; i < 5; i++) {
            ticketRepository.save(new Ticket(1,i,5000,show));
        }
    }
}
