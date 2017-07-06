package com.techelevator.npgeekcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techelevator.ParkDAO;

@Controller
public class ParkController {
	
	@Autowired
	private ParkDAO parkDAO;
	
	@RequestMapping(path="/parkDetail", method=RequestMethod.GET)
	public String showParkDetail() {
		return "parkDetail";
	}
}
