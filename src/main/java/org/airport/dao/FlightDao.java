package org.airport.dao;

import org.airport.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightDao extends JpaRepository<Flight, Integer> {

    List<Flight> findAll();

    Flight findFlightById(int id);

    Flight findFlightByName(String name);
}
