package org.airport.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Object Relational Mapping for Airport table.
 */
@Entity
@Table(name = "RESERVATION")
@Data
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @ManyToOne
    @JoinColumn(name = "GATE_ID", referencedColumnName = "ID")
    private Gate gate;
}
