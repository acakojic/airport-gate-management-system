package org.airport.http.controller;

import org.airport.dto.GateDto;
import org.airport.http.exceptions.ResourceNotFoundException;
import org.airport.service.GateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * Rest Controller for gate.
 */
@RestController
public class GateController implements GateApi {

    @Autowired
    private GateService gateService;


    @Override
    public ResponseEntity<List<GateDto>> gatesGet() {

        List<GateDto> gates = this.gateService.findAll();

        return  ResponseEntity.status(HttpStatus.OK).body(gates);
    }

    @Override
    public ResponseEntity<GateDto> gateUpdateStatus(int id, GateDto gateDto) {

        GateDto view = this.gateService.updateGate(id, gateDto);

        if(view == null) {

            throw new ResourceNotFoundException();
        }

        return ResponseEntity.ok(view);
    }
}
