package org.tickets.germes.app.model.search.criteria;


import org.tickets.germes.app.model.entity.transport.TransportType;

/**
 * Filtering criteria for search stations operation
 */
public class StationCriteria {
	/**
	 * City name
	 */
	private String name;

	private TransportType transportType;

	/**
	 * Station's address: street, zipCode, building number
	 */
	private String address;
	
	/**
	 * Returns filtering criteria to search stations that
	 * contains specified name parameter
	 */
	public static StationCriteria byName(String name) {
		return new StationCriteria(name);
	}
	
	public StationCriteria() {		
	}

	private StationCriteria(final String name) {
		this.name = name;
	}
	
	public StationCriteria(final TransportType transportType) {
		this.transportType = transportType;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TransportType getTransportType() {
		return transportType;
	}

	public void setTransportType(TransportType transportType) {
		this.transportType = transportType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}
