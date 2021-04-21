package org.airport.http.controller;

import io.swagger.annotations.*;
import org.airport.dto.GateDto;
import org.airport.dto.RestError;
import org.airport.util.ApiResponseCodeMessages;
import org.airport.util.AppControllerRoutes;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;


@Api(value = "gates", description = "the gate API")
@RequestMapping(value = AppControllerRoutes.GATE)
public interface GateApi {

    @ApiOperation(value = "Search Gates",
            nickname = "gatesGet",
            notes = "Get collections of Gates",
            response = GateDto.class,
            responseContainer = "List",
            tags={  })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = ApiResponseCodeMessages.CODE_200, response = GateDto.class, responseContainer = "List"),
            @ApiResponse(code = 403, message = ApiResponseCodeMessages.CODE_403, response = RestError.class),
            @ApiResponse(code = 500, message = ApiResponseCodeMessages.CODE_500, response = RestError.class) })
    @RequestMapping(value = "",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<List<GateDto>> gatesGet();


    @ApiOperation(value = "Update existing Gate",
            nickname = "gateIdPut",
            notes = "Updates gate based on its id",
            response = GateDto.class, tags={  })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = ApiResponseCodeMessages.CODE_200, response = GateDto.class),
            @ApiResponse(code = 400, message = ApiResponseCodeMessages.CODE_400, response = RestError.class),
            @ApiResponse(code = 403, message = ApiResponseCodeMessages.CODE_403, response = RestError.class),
            @ApiResponse(code = 404, message = ApiResponseCodeMessages.CODE_404, response = RestError.class),
            @ApiResponse(code = 500, message = ApiResponseCodeMessages.CODE_500, response = RestError.class) })
    @RequestMapping(value = "/{id}",
            produces = { "application/json" },
            method = RequestMethod.PUT)
    ResponseEntity<GateDto> gateUpdateStatus(@ApiParam(value = "",required=true) @PathVariable("id") int id, @RequestBody GateDto gateDto);

}
