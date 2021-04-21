package org.airport.dao;

import org.airport.model.Gate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GateDao extends JpaRepository<Gate, Integer>, GateDaoCustom {

    List<Gate> findAll();

    Gate findGateById(int id);

    Gate findGateByFlightId(int id);

    Gate findFirstByFlightIsNull();

    Gate findFirstByStatusEquals(String status);
}
