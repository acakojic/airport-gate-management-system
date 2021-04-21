package org.airport.util;


/**
 * Defined http method responses for Application controllers.
 */
public final class ApiResponseCodeMessages {

    public static final String CODE_200 = "OK";

    public static final String CODE_200_UPDATED = "Resource updated successfully";

    public static final String CODE_200_DELETED = "Resource deleted successfully";

    public static final String CODE_201 = "Resource created successfully";

    // Client errors
    public static final String CODE_400 = "Bad request, invalid input or parameters";

    public static final String CODE_403 = "Forbidden";

    public static final String CODE_404 = "Resource could not be found";

    // Server errors
    public static final String CODE_500 = "Internal error, something went wrong";

}
