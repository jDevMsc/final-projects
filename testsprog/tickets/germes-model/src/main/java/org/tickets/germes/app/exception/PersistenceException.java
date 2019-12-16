package org.tickets.germes.app.exception;

import org.tickets.germes.app.exception.base.AppException;

/**
 * Signals about data access layer unexpected situations
 *
 */
public class PersistenceException extends AppException {


	public PersistenceException(String message, Throwable cause) {
		super(message, cause);
	}

	public PersistenceException(String message) {
		super(message);
	}

}
