package org.airport.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * Base data transfer object for Gate model.
 */
@Data
@ApiModel(description = "Gate request and response object.")
public class GateDto {

    private String name;
    private int flightId;
    private String status;
}
