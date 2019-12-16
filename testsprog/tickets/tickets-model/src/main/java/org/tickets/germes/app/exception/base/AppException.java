package org.tickets.germes.app.exception.base;

/**
 * Base class for all application-specific exceptions
 *
 */
public abstract class AppException extends RuntimeException {


	public AppException(String message, Throwable cause) {
		super(message, cause);
	}

	public AppException(String message) {
		super(message);
	}	
}
