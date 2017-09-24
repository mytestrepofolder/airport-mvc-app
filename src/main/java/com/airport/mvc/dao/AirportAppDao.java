package com.airport.mvc.dao;

import java.util.List;
import java.util.Map;

import com.airport.mvc.entity.Country;
import com.airport.mvc.entity.results.AirportRunwayTypeResults;
import com.airport.mvc.entity.results.CountryAirportResults;

public interface AirportAppDao {

	void readCountryCSV();

	void readAirportCSV();

	void readRunwayCSV();

	List<CountryAirportResults> getAirportsRunwaysOnCode(String countryCode);

	List<CountryAirportResults> getAirportsRunwaysOnName(String countryName);

	Map<Country, Integer> getTenCountriesWithMaxAirports();

	Map<Country, Integer> getTenCountriesWithLeastAirports();

	List<AirportRunwayTypeResults> typeOfRunwaysPerCountry();

}
