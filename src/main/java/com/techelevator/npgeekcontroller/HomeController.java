package com.techelevator.npgeekcontroller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.Park;
import com.techelevator.ParkDAO;
import com.techelevator.Weather;
import com.techelevator.WeatherDAO;

@Controller
@SessionAttributes("userTemp")
public class HomeController {

	@Autowired
	private ParkDAO parkDAO;
	@Autowired
	private WeatherDAO weatherDAO;
	
	@RequestMapping(path="/", method=RequestMethod.GET)
	public String displayHomePage(HttpServletRequest request) {
		List <Park> parkList = parkDAO.getAllParks();
		request.setAttribute("parkList", parkList);
		return "homePage";
	}
	
	@RequestMapping(path="/parkDetail", method=RequestMethod.GET)
	public String displayParkDetail(HttpServletRequest request, @RequestParam String parkCode, ModelMap model) {
		parkCode.toUpperCase();
		Park ourPark = parkDAO.getParkByParkCode(parkCode);
		request.setAttribute("ourPark", ourPark);
		List<Weather> weatherList = weatherDAO.getWeatherByParkCode(parkCode);
		request.setAttribute("weatherList", weatherList);
		if(model.get("userTemp") == null) {
			model.addAttribute("userTemp", "Fahrenheit");
		}
		return "parkDetail";
	}
	
	@RequestMapping(path="/parkDetail", method=RequestMethod.POST)
	public String refreshParkDetail(RedirectAttributes redirectAttributes, @RequestParam String parkCode, ModelMap model, @RequestParam String radios) {
		model.addAttribute("userTemp", radios);
		redirectAttributes.addAttribute("parkCode", parkCode);
		return "redirect:/parkDetail";
	}
	
	
	
}
