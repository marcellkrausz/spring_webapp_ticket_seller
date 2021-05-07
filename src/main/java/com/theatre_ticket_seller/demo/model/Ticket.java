package com.theatre_ticket_seller.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Setter
@Getter
@Entity
public class Ticket {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private int rowNumber;
    private int seatNumber;
    private int price;
    private boolean isSold;

    @ManyToOne
    private Show show;

    public Ticket() {
    }

    public Ticket(int rowNumber, int seatNumber, int price) {
        this.rowNumber = rowNumber;
        this.seatNumber = seatNumber;
        this.price = price;
        this.isSold = false;
    }

    public Ticket(int rowNumber, int seatNumber, int price, Show show) {
        this.rowNumber = rowNumber;
        this.seatNumber = seatNumber;
        this.price = price;
        this.isSold = false;
        this.show = show;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(Id, ticket.Id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "Id=" + Id +
                ", rowNumber=" + rowNumber +
                ", seatNumber=" + seatNumber +
                ", price=" + price +
                ", isSold=" + isSold +
                ", show=" + show +
                '}';
    }
}
