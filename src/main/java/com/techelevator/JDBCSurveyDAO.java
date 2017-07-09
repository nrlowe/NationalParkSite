package com.techelevator;

import java.util.LinkedHashMap;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCSurveyDAO implements SurveyDAO {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCSurveyDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void insertSurveyResult(String parkCode, String email, String state, String activity) {
		String sqlSurveyResultInput = "INSERT INTO survey_result(parkCode, emailaddress, state, activitylevel) VALUES(?, ?, ?, ?)";
		jdbcTemplate.update(sqlSurveyResultInput, parkCode, email, state, activity);
	}

	@Override	
	public LinkedHashMap<String, Integer> voteTally() {
		LinkedHashMap<String, Integer> ourMap = new LinkedHashMap<String, Integer>();
		String sqlSurveyResult = "SELECT parkcode, count(parkcode) " + "FROM survey_result " + "GROUP BY survey_result.parkcode " + "ORDER BY count DESC " + "LIMIT 5 ";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSurveyResult);
		while(results.next())
			ourMap.put(results.getString("parkcode"), results.getInt("count"));
		return ourMap;
	}

}
