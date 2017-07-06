package com.techelevator.npgeekcontroller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.Park;
import com.techelevator.ParkDAO;

@Controller
public class HomeController {

	@Autowired
	private ParkDAO parkDAO;
	
	@RequestMapping(path="/", method=RequestMethod.GET)
	public String displayHomePage(HttpServletRequest request) {
		List <Park> parkList = parkDAO.getAllParks();
		request.setAttribute("parkList", parkList);
		return "homePage";
	}
	
	@RequestMapping(path="/parkDetail", method=RequestMethod.GET)
	public String displayParkDetail(HttpServletRequest request, @RequestParam String parkCode) {
		Park ourPark = parkDAO.getParkByParkCode(parkCode);
		request.setAttribute("ourPark", ourPark);
		return "parkDetail";
	}
	
	
	
	
}
