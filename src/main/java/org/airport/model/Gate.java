package org.airport.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Object Relational Mapping for Gate table.
 */
@Entity
@Table(name = "GATE")
@Data
public class Gate implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "STATUS")
    private String status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FLIGHT_ID")
    private Flight flight;

    @OneToMany(mappedBy = "gate", cascade = CascadeType.ALL)
    private List<Reservation> reservations;
}
