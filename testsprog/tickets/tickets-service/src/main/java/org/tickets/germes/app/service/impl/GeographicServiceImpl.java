package org.tickets.germes.app.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.tickets.germes.app.model.entity.geography.City;
import org.tickets.germes.app.service.GeographicService;
import org.tickets.germes.app.util.CommonUtil;

/**
 * Default implementation of the GeographicService}
 */
public class GeographicServiceImpl implements GeographicService {
	/**
	 * Internal list of cities
	 */
	private final List<City> cities;
	
	public GeographicServiceImpl() {
		cities = new ArrayList<>();
	}

	@Override
	public List<City> findCities() {
		return CommonUtil.getSafeList(cities);
	}

	@Override
	public void saveCity(City city) {
		if(!cities.contains(city)) {
			cities.add(city);
		}
	}

}
