package com.techelevator.npgeekcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ParkController {
	
	@Autowired
	private ParkDao parkDao;
	
	@RequestMapping(path="/parkDetail", method=RequestMethod.GET)
	public String showParkDetail() {
		return "parkDetail";
	}
}
