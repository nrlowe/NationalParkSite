package com.techelevator.npgeekcontroller;

import java.util.LinkedHashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.Park;
import com.techelevator.ParkDAO;
import com.techelevator.Survey;
import com.techelevator.SurveyDAO;

@Controller
public class SurveyController {
	
	@Autowired
	private ParkDAO parkDAO;
	
	@Autowired
	private SurveyDAO surveyDAO;
	
	@RequestMapping(path="/surveyInput", method=RequestMethod.GET)
	public String displayHomePage(HttpServletRequest request, Model modelHolder) {
		if(!modelHolder.containsAttribute("survey")) {
			modelHolder.addAttribute("survey", new Survey());
		}

		List <Park> parkList = parkDAO.getAllParks();
		request.setAttribute("parkList", parkList);
		return "surveyInput";
	}
	
	@RequestMapping(path="/surveyInput", method=RequestMethod.POST)
	public String submitSurvey(HttpServletRequest request, @Valid @ModelAttribute("survey") Survey survey, BindingResult result, RedirectAttributes attr) {
		if(result.hasErrors()) {
			attr.addFlashAttribute("survey", survey);
			attr.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "survey", result);
			
			return "redirect:/surveyInput";
		}

		surveyDAO.insertSurveyResult(survey.getParkCode(), survey.getEmail(), survey.getState(), survey.getActivity());
		return "redirect:/surveyResults";
	}
	
	@RequestMapping(path="/surveyResults", method=RequestMethod.GET)
	public String showSurveyResults(HttpServletRequest request) {
		LinkedHashMap<String, Integer> results = surveyDAO.voteTally();
		request.setAttribute("resultMap", results);
		return "surveyResults";
	}
}
