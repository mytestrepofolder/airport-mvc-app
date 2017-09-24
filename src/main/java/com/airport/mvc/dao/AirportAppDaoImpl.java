package com.airport.mvc.dao;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.airport.mvc.entity.Airport;
import com.airport.mvc.entity.Country;
import com.airport.mvc.entity.Runway;
import com.airport.mvc.entity.results.AirportRunwayTypeResults;
import com.airport.mvc.entity.results.CountryAirportResults;
import com.opencsv.CSVReader;

/**
 * @author Plabon.Kakoti
 *
 */

@Component
public class AirportAppDaoImpl implements AirportAppDao {

	// src\\main\\webapp\\WEB-INF\\files
	private static final String COUNTRY_DATA = "countries.csv";
	private static final String AIRPORT_DATA = "airports.csv";
	private static final String RUNWAY_DATA = "runways.csv";
	private List<Country> countries = new ArrayList<Country>();
	private List<Airport> airports = new ArrayList<>();
	private List<Runway> runwayList = new ArrayList<>();
	private Map<Country, Integer> sortedCountriesAirportMap = new LinkedHashMap<>();
	private Map<Country, Integer> sortedMap = new LinkedHashMap<>();
	private static String currentDir = Paths.get(".").toAbsolutePath().toString();
	private static String absPath = currentDir.substring(0, currentDir.length() - 1).replace("\\", "\\\\");

	public AirportAppDaoImpl() {
		readCountryCSV();
		readAirportCSV();
		readRunwayCSV();
	}

	static CSVReader readFileLocation(String fileName) {
		CSVReader csvReader = new CSVReader(new InputStreamReader(AirportAppDaoImpl.class.getResourceAsStream("/" + fileName)), ',', '\n', 1);
		return csvReader;
	}

	@Override
	public void readCountryCSV() {
		CSVReader reader;
		try {
			reader = AirportAppDaoImpl.readFileLocation(COUNTRY_DATA);
			// reader = new CSVReader(new FileReader(absPath + COUNTRY_DATA),
			// ',', '\n', 1);
			String[] record = null;

			while ((record = reader.readNext()) != null) {
				Country country = new Country();
				country.setId(Integer.parseInt(record[0]));
				country.setCode(record[1]);
				country.setName(record[2]);
				country.setContinent(record[3]);
				country.setWikipedia_link(record[4]);
				country.setKeywords(record[5]);
				countries.add(country);

			}
		} catch (IOException | NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// return countries;
	}

	@Override
	public void readAirportCSV() {
		CSVReader reader;

		try {
			reader = AirportAppDaoImpl.readFileLocation(AIRPORT_DATA);
			// reader = new CSVReader(new FileReader(absPath + AIRPORT_DATA),
			// ',', '\n', 1);
			String[] record = null;
			while ((record = reader.readNext()) != null) {
				Airport airport = new Airport();
				airport.setId(Integer.parseInt(record[0]));
				airport.setIdent(record[1]);
				airport.setType(record[2]);
				airport.setName(record[3]);
				airport.setLatitute_deg(record[4]);
				airport.setLongitude_deg(record[5]);
				airport.setElevation_ft(record[6]);
				airport.setContinent(record[7]);
				airport.setIso_country(record[8]);
				airport.setMunicipality(record[9]);
				airport.setScheduled_service(record[10]);
				airport.setGps_code(record[11]);
				airport.setIata_code(record[12]);
				airport.setLocal_code(record[13]);
				airport.setHome_link(record[14]);
				airport.setWikipedia_link(record[15]);
				airport.setKeywords(record[16]);
				airports.add(airport);
			}

		} catch (IOException | NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void readRunwayCSV() {
		CSVReader reader;
		// List<Runway> runwayList = new ArrayList<>();
		try {
			reader = AirportAppDaoImpl.readFileLocation(RUNWAY_DATA);
			// reader = new CSVReader(new FileReader(absPath + RUNWAY_DATA),
			// ',', '\n', 1);
			String[] record = null;
			while ((record = reader.readNext()) != null) {
				Runway runway = new Runway();
				runway.setId(record[0]);
				runway.setAirport_ref(Integer.parseInt(record[1]));
				runway.setAirport_ident(record[2]);
				runway.setLength_ft(record[3]);
				runway.setWidth_ft(record[4]);
				runway.setSurface(record[5]);
				runway.setLighted(record[6]);
				runway.setClosed(record[7]);
				runway.setLe_ident(record[8]);
				runway.setLe_latitude_deg(record[9]);
				runway.setLe_longitude_deg(record[10]);
				runway.setLe_elevation_ft(record[11]);
				runway.setLe_heading_degT(record[12]);
				runway.setLe_displaced_threshold_ft(record[13]);
				runway.setHe_ident(record[14]);
				runway.setHe_latitude_deg(record[15]);
				runway.setHe_longitude_deg(record[16]);
				runway.setHe_elevation_ft(record[17]);
				runway.setHe_heading_degT(record[18]);
				runway.setHe_displaced_threshold_ft(record[19]);
				runwayList.add(runway);
			}
		} catch (IOException | NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<CountryAirportResults> getAirportsRunwaysOnCode(String countryCode) {
		// List<Airport> countryAirports = new ArrayList<Airport>();
		List<CountryAirportResults> finalResults = new ArrayList<>();
		List<Runway> runwayResults = null;
		CountryAirportResults countryAirportResult = null;

		List<Airport> countryAirports = airports.stream().filter(i -> i.getIso_country().equalsIgnoreCase(countryCode)).collect(Collectors.toList());

		if (countryAirports.size() == 0) {
			return new ArrayList<CountryAirportResults>();
		}

		for (Airport airport : countryAirports) {
			countryAirportResult = new CountryAirportResults();
			runwayResults = new ArrayList<>();
			Iterator<Runway> itr = runwayList.iterator();
			while (itr.hasNext()) {
				Runway runway = (Runway) itr.next();
				if (airport.getId() == runway.getAirport_ref()) {
					runwayResults.add(runway);
				}
			}
			countryAirportResult.setAirport(airport);
			countryAirportResult.setRunways(runwayResults);
			finalResults.add(countryAirportResult);
		}
		return finalResults;
	}

	@Override
	public List<CountryAirportResults> getAirportsRunwaysOnName(String countryName) {
		String code = null;
		if (countryName != null) {
			Optional<String> cc = countries.stream().filter(i -> i.getName().contains(countryName)).map(i -> i.getCode()).findFirst();

			if (!cc.isPresent()) {
				return new ArrayList<CountryAirportResults>();
			} else {
				code = cc.get();
			}
		}
		return getAirportsRunwaysOnCode(code);
	}

	private static Map<Country, Integer> getCountryAiportMap(List<Country> countrylist, List<Airport> airportList) {

		Map<Country, Integer> apCount = new HashMap<>();
		for (Country country : countrylist) {

			Iterator<Airport> itr = airportList.iterator();
			int count = 0;
			while (itr.hasNext()) {
				Airport airport = (Airport) itr.next();
				if (airport.getIso_country().equalsIgnoreCase(country.getCode())) {
					count++;
					apCount.put(country, count);
				}
			}
			count = 0;
		}

		return apCount;
	}

	@Override
	public Map<Country, Integer> getTenCountriesWithMaxAirports() {
		Map<Country, Integer> apCount = getCountryAiportMap(countries, airports);

		// Map<String, Integer> sortedMap1 =
		// apCount.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
		// .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
		// (oldValue, newValue) -> oldValue, LinkedHashMap::new));
		apCount.entrySet().stream().sorted(Map.Entry.<Country, Integer>comparingByValue().reversed()).limit(10).forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));
		// System.out.println(System.lineSeparator());
		// sortedMap.entrySet().stream().forEach(k ->
		// System.out.println(k.getKey().getName() + ": " + k.getValue()));

		return sortedMap;
	}

	@Override
	public Map<Country, Integer> getTenCountriesWithLeastAirports() {
		Map<Country, Integer> apCount = getCountryAiportMap(countries, airports);

		apCount.entrySet().stream().sorted(Map.Entry.<Country, Integer>comparingByValue()).limit(10).forEachOrdered(x -> sortedCountriesAirportMap.put(x.getKey(), x.getValue()));
		// System.out.println(System.lineSeparator());
		// sortedCountriesAirportMap.entrySet().stream().forEach(k ->
		// System.out.println(k.getKey().getName() + ": " + k.getValue()));
		return sortedCountriesAirportMap;
	}

	@Override
	public List<AirportRunwayTypeResults> typeOfRunwaysPerCountry() {
		// TODO Auto-generated method stub
		List<AirportRunwayTypeResults> results = new ArrayList<>();
		List<String> runwayTypeResults = null;
		AirportRunwayTypeResults countryRunwayTypes = null;
		List<Country> countryList = new ArrayList<>(sortedMap.keySet());

		for (Country c : countryList) {
			countryRunwayTypes = new AirportRunwayTypeResults();
			List<Airport> countryAirports = airports.stream().filter(i -> i.getIso_country().equalsIgnoreCase(c.getCode())).collect(Collectors.toList());
			runwayTypeResults = new ArrayList<>();
			for (Airport airport : countryAirports) {
				Iterator<Runway> itr = runwayList.iterator();
				while (itr.hasNext()) {
					Runway runway = (Runway) itr.next();
					if (airport.getId() == runway.getAirport_ref()) {
						if (!runway.getSurface().equals("") && !runwayTypeResults.contains(runway.getSurface())) {
							runwayTypeResults.add(runway.getSurface());
							runwayTypeResults.add(",");
						}
					}
				}
				countryRunwayTypes.setRunwayTypes(runwayTypeResults);
			}
			countryRunwayTypes.setCountryName(c.getName());
			results.add(countryRunwayTypes);
		}
		return results;
	}

}
