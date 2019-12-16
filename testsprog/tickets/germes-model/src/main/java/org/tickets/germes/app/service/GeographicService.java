package org.tickets.germes.app.service;

import java.util.List;
import org.tickets.germes.app.model.entity.geography.City;

/**
 * Perform operations over geographic entities
 */
public interface GeographicService {

	/**
	 * Returns list of existing cities
	 */
	List<City> findCities();
	
	/**
	 * Saves specified city instance
	 */
	void saveCity(City city);
}
