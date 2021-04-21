package org.airport.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Object Relational Mapping for Gate table.
 */
@Entity
@Table(name = "GATE")
@Data
public class Gate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "STATUS")
    private String status;

    @OneToOne
    @JoinColumn(name = "FLIGHT_ID")
    private Flight flight;

}
