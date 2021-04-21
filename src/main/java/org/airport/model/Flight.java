package org.airport.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Object Relational Mapping for Airport table.
 */
@Entity
@Table(name = "FLIGHT")
@Data
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "NAME")
    private String name;

    @OneToOne(mappedBy = "flight")
    private Gate gate;
}
