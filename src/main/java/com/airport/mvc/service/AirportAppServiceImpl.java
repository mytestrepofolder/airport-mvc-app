/**
 * 
 */
package com.airport.mvc.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airport.mvc.dao.AirportAppDao;
import com.airport.mvc.entity.Country;
import com.airport.mvc.entity.results.AirportRunwayTypeResults;
import com.airport.mvc.entity.results.CountryAirportResults;

/**
 * @author Plabon.Kakoti
 *
 */

@Service
public class AirportAppServiceImpl implements AirportAppService {

	@Autowired
	AirportAppDao dao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.airport.mvc.service.AirportAppService#listgetAirportsRunwaysOnCode(
	 * java.lang.String)
	 */
	@Override
	public List<CountryAirportResults> getAirportsRunwaysOnCode(String countryCode) {
		// TODO Auto-generated method stub
		return dao.getAirportsRunwaysOnCode(countryCode);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.airport.mvc.service.AirportAppService#listgetAirportsRunwaysOnName(
	 * java.lang.String)
	 */
	@Override
	public List<CountryAirportResults> getAirportsRunwaysOnName(String countryName) {
		// TODO Auto-generated method stub
		return dao.getAirportsRunwaysOnName(countryName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.airport.mvc.service.AirportAppService#getTenCountriesWithMaxAirports(
	 * )
	 */
	@Override
	public Map<Country, Integer> getTenCountriesWithMaxAirports() {
		// TODO Auto-generated method stub
		return dao.getTenCountriesWithMaxAirports();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.airport.mvc.service.AirportAppService#
	 * getTenCountriesWithLeastAirports()
	 */
	@Override
	public Map<Country, Integer> getTenCountriesWithLeastAirports() {
		// TODO Auto-generated method stub
		return dao.getTenCountriesWithLeastAirports();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.airport.mvc.service.AirportAppService#typeOfRunwaysPerCountry()
	 */
	@Override
	public List<AirportRunwayTypeResults> typeOfRunwaysPerCountry() {
		// TODO Auto-generated method stub
		return dao.typeOfRunwaysPerCountry();
	}

}
