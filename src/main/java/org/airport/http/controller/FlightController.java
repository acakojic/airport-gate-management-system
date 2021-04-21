package org.airport.http.controller;

import org.airport.dto.GateDto;
import org.airport.http.exceptions.ResourceNotFoundException;
import org.airport.service.GateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


/**
 * Rest Controller for gate.
 */
@RestController
public class FlightController implements FlightApi {

    @Autowired
    private GateService gateService;


    @Override
    public ResponseEntity<GateDto> parkFlightToGate(int id) {
        GateDto view = this.gateService.getGate(id);

        if(view == null) {

            throw new ResourceNotFoundException();
        }

        return ResponseEntity.ok(view);
    }
}
