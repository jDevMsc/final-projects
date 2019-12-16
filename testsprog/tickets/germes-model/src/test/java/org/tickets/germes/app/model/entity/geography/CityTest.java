package org.tickets.germes.app.model.entity.geography;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Contains unit-tests to check functionality of {@link City} class
 */
public class CityTest {

    @Test
    public void testAddValidStationSuccess() {
        Station station = new Station();

        City city = new City();
        city.addStation(station);

        assertTrue(containsStation(city, station));
    }

    private boolean containsStation(City city, Station station) {
        return city.getStations().contains(station);
    }
}