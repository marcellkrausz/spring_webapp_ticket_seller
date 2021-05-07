package com.theatre_ticket_seller.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Setter
@Getter
@Entity
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Date date;
    private String description;

    @ManyToOne
    private Theatre theatre;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "show")
    private Set<Ticket> ticketSet = new HashSet<>();

    public Show() {
    }

    public Show(String name, Date date, String description) {
        this.name = name;
        this.date = date;
        this.description = description;
    }

    public Show(String name, Date date, String description, Theatre theatre) {
        this.name = name;
        this.date = date;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Show show = (Show) o;
        return Objects.equals(id, show.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Show{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", theatre=" + theatre +
                ", ticketSet=" + ticketSet +
                '}';
    }
}
