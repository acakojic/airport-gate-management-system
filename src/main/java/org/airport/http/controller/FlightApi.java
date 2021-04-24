package org.airport.http.controller;

import io.swagger.annotations.*;
import org.airport.dto.FlightDto;
import org.airport.dto.GateDto;
import org.airport.dto.RestError;
import org.airport.util.ApiResponseCodeMessages;
import org.airport.util.AppControllerRoutes;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Api(value = "flights", description = "the Flight API")
@RequestMapping(value = AppControllerRoutes.FLIGHT)
public interface FlightApi {

    @ApiOperation(value = "Get Gate for Flight and park it to Gate",
            nickname = "flight",
            notes = "Get gate",
            response = FlightDto.class, tags={  })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = ApiResponseCodeMessages.CODE_200, response = FlightDto.class),
            @ApiResponse(code = 403, message = ApiResponseCodeMessages.CODE_403, response = RestError.class),
            @ApiResponse(code = 500, message = ApiResponseCodeMessages.CODE_500, response = RestError.class) })
    @RequestMapping(value = "/{id}/park",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<GateDto> parkFlightToGate(@ApiParam(value = "ID of flight",required=true) @PathVariable("id") int id);
}
