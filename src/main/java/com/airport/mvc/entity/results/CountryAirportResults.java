package com.airport.mvc.entity.results;

import java.util.List;

import com.airport.mvc.entity.Airport;
import com.airport.mvc.entity.Runway;

public class CountryAirportResults {

	Airport airport;
	List<Runway> runways;

	public Airport getAirport() {
		return airport;
	}

	public void setAirport(Airport airport) {
		this.airport = airport;
	}

	public List<Runway> getRunways() {
		return runways;
	}

	public void setRunways(List<Runway> runways) {
		this.runways = runways;
	}

}
