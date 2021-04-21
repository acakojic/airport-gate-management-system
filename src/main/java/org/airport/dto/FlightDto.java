package org.airport.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * Base data transfer object for Gate model.
 */
@Data
@ApiModel(description = "Flight request and response object.")
public class FlightDto {

    private String name;
    private String status;
}
