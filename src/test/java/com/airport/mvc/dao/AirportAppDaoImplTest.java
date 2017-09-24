package com.airport.mvc.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.airport.mvc.entity.Country;
import com.airport.mvc.entity.results.CountryAirportResults;

public class AirportAppDaoImplTest {

	private AirportAppDao apDao = new AirportAppDaoImpl();

	@Test
	public void testGetAirportsRunwaysOnCode() {
		List<CountryAirportResults> queryOutput = apDao.getAirportsRunwaysOnCode("VE");
		CountryAirportResults countryApRes = queryOutput.stream().findFirst().get();
		assertEquals("San Diego De Cabrutica Airport", countryApRes.getAirport().getName());
	}

	@Test
	public void testGetAirportsRunwaysOnName() {
		List<CountryAirportResults> queryOutput = apDao.getAirportsRunwaysOnName("Venezu");
		CountryAirportResults countryApRes = queryOutput.stream().findFirst().get();
		assertEquals("San Diego De Cabrutica Airport", countryApRes.getAirport().getName());
	}

	@Test
	public void testGetTenCountriesWithMaxAirports() {
		Map<Country, Integer> tenCountriesWithMaxAirports = apDao.getTenCountriesWithMaxAirports();
		int value = tenCountriesWithMaxAirports.values().iterator().next();
		assertEquals(21476, value);

	}

	@Test
	public void testGetTenCountriesWithLeastAirports() {
		Map<Country, Integer> tenCountriesWithMaxAirports = apDao.getTenCountriesWithLeastAirports();
		int value = tenCountriesWithMaxAirports.values().iterator().next();
		assertEquals(1, value);

	}

}
