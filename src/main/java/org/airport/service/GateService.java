package org.airport.service;

import org.airport.dto.GateDto;

import java.util.List;

/**
 * Gate Service interface.
 */
public interface GateService {

    /**
     * Gets Gate.
     *
     * @return gateDto
     */
    List<GateDto> findAll();

    /**
     * Gets Gate.
     * @param number 		the flight number
     * @return gateDto
     */
    GateDto getGate(int number);

    /**
     * Update Gate.
     * @param id 		the gate id
     * @param gateDto   the GateDto gateDto(flightId, status)
     * @return gateDto
     */
    GateDto updateGate(int id, GateDto gateDto);
}
