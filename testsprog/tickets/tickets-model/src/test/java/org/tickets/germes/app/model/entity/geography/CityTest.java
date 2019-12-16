package org.tickets.germes.app.model.entity.geography;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.tickets.germes.app.model.entity.transport.TransportType;

/**
 * Contains unit-tests to check functionality of {@link City} class
 */
public class CityTest {
    private City city;

    @Before
    public void setup() {
        city = new City("Moscow");
    }

    @Test
    public void testAddValidStationSuccess() {
        Station station = city.addStation(TransportType.AUTO);
        assertTrue(containsStation(city, station));
        assertEquals(city, station.getCity());
    }

    @Test(expected= NullPointerException.class)
    public void testAddNullStationFailure() {
        city.addStation(null);
        assertTrue(false);
    }


    @Test
    public void testRemoveStationSuccess() {
        Station station = city.addStation(TransportType.AVIA);
        city.removeStation(station);
        assertTrue(city.getStations().isEmpty());
    }

    @Test(expected= NullPointerException.class)
    public void testRemoveNullStationFailure() {
        city.removeStation(null);
        assertTrue(false);
    }

    private boolean containsStation(City city, Station station) {
        return city.getStations().contains(station);
    }

}
