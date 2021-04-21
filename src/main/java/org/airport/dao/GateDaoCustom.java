package org.airport.dao;

import org.airport.model.Gate;
import org.springframework.data.jpa.repository.Query;

public interface GateDaoCustom {

    @Query(value = "FROM Gate g where g.flight is null")
    Gate getGateIfFlightIsNotAssigned();
}
