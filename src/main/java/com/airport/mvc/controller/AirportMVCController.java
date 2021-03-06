package com.airport.mvc.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.airport.mvc.entity.Country;
import com.airport.mvc.entity.results.AirportRunwayTypeResults;
import com.airport.mvc.entity.results.CountryAirportResults;
import com.airport.mvc.service.AirportAppService;
/**
 * @author Plabon.Kakoti
 * @version 1.0
 *
 */
@Controller
public class AirportMVCController {

	@Autowired
	AirportAppService airportService;

	@RequestMapping(value = "/")
	public String airportDetails(ModelMap model) {
		return "airportDetails";
	}

	@RequestMapping(value = "search", method = RequestMethod.GET)
	public String userSearchQuery(ModelMap model) {
		return "userSerachQuery";
	}

	@RequestMapping(value = "reports", method = RequestMethod.GET)
	public String reports(ModelMap model) {

		Map<Country, Integer> tenCountriesWithMaxAirports = airportService.getTenCountriesWithMaxAirports();
		Map<Country, Integer> tenCountriesWithLeastAirports = airportService.getTenCountriesWithLeastAirports();
		List<AirportRunwayTypeResults> typeOfRunwaysPerCountry = airportService.typeOfRunwaysPerCountry();
		model.addAttribute("tenCountriesWithMaxAirports", tenCountriesWithMaxAirports);
		model.addAttribute("tenCountriesWithLeastAirports", tenCountriesWithLeastAirports);
		model.addAttribute("typeOfRunwaysPerCountry", typeOfRunwaysPerCountry);
		return "reportsView";
	}

	@RequestMapping(value = "searchcode", method = RequestMethod.GET)
	public String searchCode(ModelMap model, HttpServletRequest request) {
		String searchTxt = request.getParameter("searchCodeText");
		searchTxt = searchTxt.toUpperCase();
		if (searchTxt.isEmpty()) {
			return "userSerachQuery";
		}
		List<CountryAirportResults> queryOutput = airportService.getAirportsRunwaysOnCode(searchTxt);
		if (queryOutput.isEmpty()) {
			return "error";
		}
		model.addAttribute("searchTxt", searchTxt);
		model.addAttribute("queryOutput", queryOutput);
		return "queryResults";

	}

	@RequestMapping(value = "searchname", method = RequestMethod.GET)
	public String searchName(ModelMap model, HttpServletRequest request) {
		String searchTxt = request.getParameter("searchNameText");
		if (searchTxt.isEmpty()) {
			return "userSerachQuery";
		}
		searchTxt = searchTxt.substring(0, 1).toUpperCase() + searchTxt.substring(1);
		List<CountryAirportResults> queryOutput = airportService.getAirportsRunwaysOnName(searchTxt);
		if (queryOutput.isEmpty()) {
			return "error";
		}
		model.addAttribute("searchTxt", searchTxt);
		model.addAttribute("queryOutput", queryOutput);
		return "queryResults";

	}

}
