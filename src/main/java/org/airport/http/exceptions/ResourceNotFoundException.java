package org.airport.http.exceptions;

import org.airport.util.ApiResponseCodeMessages;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception thrown in case when resource could not be found.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = ApiResponseCodeMessages.CODE_404)
public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -3381250967767715312L;
//
    public ResourceNotFoundException() {
        super("Resource could not be found");
    }
//
    public ResourceNotFoundException(String msg) {
        super(msg);
    }

}
