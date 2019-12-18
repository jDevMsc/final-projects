package org.tickets.germes.app.model.entity.geography;

import java.util.Objects;
import org.tickets.germes.app.model.entity.base.AbstractEntity;
import org.tickets.germes.app.model.entity.transport.TransportType;

/**
 * Station where passengers can get off or take specific kind
 * of transport. Multiple stations compose route of the trip.
 */
public class Station extends AbstractEntity {
	private City city;
	
	private Address address;

	private String phone;
	
	private Coordinate coordinate;
	
	private TransportType transportType;

	/**
	 * add station through city
	 */
	public Station(final City city, final TransportType transportType) {
		this.city = Objects.requireNonNull(city);
		this.transportType = Objects.requireNonNull(transportType);
	}


	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}

	public TransportType getTransportType() {
		return transportType;
	}

	public void setTransportType(TransportType transportType) {
		this.transportType = transportType;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		if (!super.equals(o)) {
			return false;
		}
		Station station = (Station) o;
		return Objects.equals(city, station.city) &&
			Objects.equals(address, station.address) &&
			Objects.equals(phone, station.phone) &&
			Objects.equals(coordinate, station.coordinate) &&
			transportType == station.transportType;
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), city, address, phone, coordinate, transportType);
	}
}
