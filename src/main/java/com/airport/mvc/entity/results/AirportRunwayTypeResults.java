package com.airport.mvc.entity.results;

import java.util.List;

public class AirportRunwayTypeResults {

	String countryName;
	List<String> runwayTypes;

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public List<String> getRunwayTypes() {
		return runwayTypes;
	}

	public void setRunwayTypes(List<String> runwayTypes) {
		this.runwayTypes = runwayTypes;
	}

	@Override
	public String toString() {
		return "AirportRunwayTypeResults [airportName=" + countryName + ", runwayTypes=" + runwayTypes + "]";
	}

}
