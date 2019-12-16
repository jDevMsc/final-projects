package org.tickets.germes.app.exception;


import org.tickets.germes.app.exception.base.AppException;

/**
 * Signals about incorrect configuration settings/parameters
 */
public class ConfigurationException extends AppException {


	public ConfigurationException(String message, Throwable cause) {
		super(message, cause);
	}

	public ConfigurationException(String message) {
		super(message);
	}

	public ConfigurationException(Throwable throwable) {
		super(throwable);
	}

}
