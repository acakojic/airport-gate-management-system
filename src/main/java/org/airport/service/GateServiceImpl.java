package org.airport.service;

import lombok.RequiredArgsConstructor;
import org.airport.dao.FlightDao;
import org.airport.dao.GateDao;
import org.airport.dto.FlightDto;
import org.airport.dto.GateDto;
import org.airport.model.Flight;
import org.airport.model.Gate;
import org.airport.util.GateStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


/**
 * Implementation of GateService.
 */
@Service
@RequiredArgsConstructor
public class GateServiceImpl implements GateService {

    private static final Logger LOG = LoggerFactory.getLogger(GateServiceImpl.class);

    @Autowired
    private GateDao gateDao;

    @Autowired
    private FlightDao flightDao;


    @Override
    public List<GateDto> findAll() {
        LOG.debug("Getting gates: {}");

        List<GateDto> gates = this.gateDao.findAll().stream().map(this::mapToDto).collect(Collectors.toList());

        return gates;
    }

    @Override
    public GateDto getGate(int id) {
        LOG.debug("Getting gate: {}");

        Flight flight = this.flightDao.findFlightById(id);
        if (flight == null) {
            LOG.error("Flight {} is not found", id);

            return null;
        }

        Gate gate = this.gateDao.findGateByFlightId(id);

        if (gate == null) {
            LOG.debug("Flight {} is not assigned to Gate ", id);

            gate = this.gateDao.findFirstByFlightIsNull();

            if (gate == null) {
                LOG.error("There is no Gate available, closed or reserved");
                return null;
            }

            gate.setFlight(flight);
            gate.setStatus(GateStatus.RESERVED.name());
            this.gateDao.saveAndFlush(gate);

            return mapToDto(gate);
        }

        return mapToDto(gate);
    }

    @Override
    public GateDto updateGate(int id, GateDto gateDto) {
        LOG.debug("Updating gate: {}");

        Gate gate = gateDao.findGateById(id);

        if (gate == null) {
            return null;
        }

        gate.setFlight(null);
        gate.setStatus(gateDto.getStatus());

        gateDao.saveAndFlush(gate);

        return gateDto;
    }

    public GateDto flightConnectToGate(FlightDto flightDto) {
        LOG.debug("Connecting Flight to Gate: {}");

        if (flightDto != null && flightDto.getName() != null && flightDto.getStatus() != null) {
            Flight flight = flightDao.findFlightByName(flightDto.getName());

            Gate gate = gateDao.findFirstByStatusEquals(flightDto.getStatus());

            return mapToDto(gate);
        }
        return null;
    }

    private GateDto mapToDto(Gate gate) {
        GateDto gateDto = new GateDto();
        gateDto.setName(gate.getName());
        if (gate.getFlight() == null) {
            gateDto.setFlightId(0);
        } else {
            gateDto.setFlightId(gate.getFlight().getId());
        }
        gateDto.setStatus(gate.getStatus());

        return gateDto;
    }
}
