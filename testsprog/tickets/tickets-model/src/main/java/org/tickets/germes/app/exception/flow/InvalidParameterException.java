package org.tickets.germes.app.exception.flow;


import org.tickets.germes.app.exception.FlowException;

/**
 * Signals that incorrect parameter was passed to method/constructor
 */
public class InvalidParameterException extends FlowException {


	public InvalidParameterException(String message) {
		super(message);
	}	
}
