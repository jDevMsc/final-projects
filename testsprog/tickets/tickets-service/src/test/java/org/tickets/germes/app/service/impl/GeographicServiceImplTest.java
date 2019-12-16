package org.tickets.germes.app.service.impl;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.tickets.germes.app.model.entity.geography.City;
import org.tickets.germes.service.GeographicService;
import org.tickets.germes.service.impl.GeographicServiceImpl;

public class GeographicServiceImplTest {
    private GeographicService service;

    @Before
    public void setup() {
        service = new GeographicServiceImpl();
    }

    @Test
    public void testNoDataReturnedAtStart() {
        List<City> cities = service.findCities();
        assertTrue(cities.isEmpty());
    }

    @Test
    public void testSaveNewCitySuccess() {
        City city = new City("Moscow");
        service.saveCity(city);

        List<City> cities = service.findCities();
        assertEquals(cities.size(), 1);
        assertEquals(cities.get(0).getName(), "Moscow");
    }
}