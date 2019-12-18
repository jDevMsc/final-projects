package org.tickets.germes.app.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.lang3.StringUtils;
import org.tickets.germes.app.model.entity.geography.City;
import org.tickets.germes.app.model.entity.geography.Station;
import org.tickets.germes.app.model.search.criteria.StationCriteria;
import org.tickets.germes.app.model.search.criteria.range.RangeCriteria;
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

	/**
	 * Auto-increment counter for entity id generation
	 */
	private int counter = 0;

	public GeographicServiceImpl() {
		cities = new ArrayList<>();
	}

	@Override
	public List<City> findCities() {
		return CommonUtil.getSafeList(cities);
	}

	@Override
	public void saveCity(City city) {
		if (!cities.contains(city)) {
			city.setId(++counter);
			cities.add(city);
		}
	}

	@Override
	public Optional<City> findCitiyById(final int id) {
		return cities.stream().filter((city) -> city.getId() == id).findFirst();
	}

	@Override
	public List<Station> searchStations(final StationCriteria criteria, final RangeCriteria rangeCriteria) {
		/**
		 * 		First, we select all cities that match the condition (if there is a condition)
		 */
		Stream<City> stream = cities.stream().filter(
			(city) -> StringUtils.isEmpty(criteria.getName()) || city.getName().equals(criteria.getName()));
			/**
			 * Then we glue all the stations in one Set for further search
			 */
		Optional<Set<Station>> stations = stream.map((city) -> city.getStations()).reduce((stations1, stations2) -> {
			Set<Station> newStations = new HashSet<>(stations2);
			newStations.addAll(stations1);
			return newStations;
		});
		/**
		 * If there are no stations at all, then return an empty list
		 */
		if(!stations.isPresent()) {
			return Collections.emptyList();
		}
		/**
		 * Otherwise, we filter out the stations according to the type of transport (if there is such a condition).
		 */
		return stations.get()
			.stream()
			.filter((station) -> criteria.getTransportType() == null
				|| station.getTransportType() == criteria.getTransportType()).collect(Collectors.toList());
	}
}
