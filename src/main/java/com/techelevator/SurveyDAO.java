package com.techelevator;


import java.util.LinkedHashMap;


public interface SurveyDAO {
	public void insertSurveyResult(String parkCode, String email, String state, String activity);
	public LinkedHashMap<String, Integer> voteTally();
}
