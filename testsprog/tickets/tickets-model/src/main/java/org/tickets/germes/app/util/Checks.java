package org.tickets.germes.app.util;

import org.tickets.germes.app.exception.flow.InvalidParameterException;

public class Checks {

    private Checks() {
    }
    /**
     * Verifies that specified check passed and throws exception otherwise
     */
    public static void checkParameter(boolean check, String message)  throws InvalidParameterException {
        if (!check) {
            throw new InvalidParameterException(message);
        }
    }

}
