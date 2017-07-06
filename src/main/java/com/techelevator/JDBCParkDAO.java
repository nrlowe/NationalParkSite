package com.techelevator;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;



@Component 
public class JDBCParkDAO implements ParkDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCParkDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List <Park> getAllParks() {
		List<Park> allParks = new ArrayList<Park>();
		String sqlSelectAllParks = "SELECT parkCode, parkName, state, parkDescription " + "FROM park ";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllParks);
		while(results.next()) {
			Park park = new Park();
			park.setParkCode(results.getString("parkCode"));
			park.setParkName(results.getString("parkName"));
			park.setParkLocation(results.getString("state"));
			park.setDescription(results.getString("parkDescription"));
			
			allParks.add(park);
		}
		return allParks;
	}
	
	@Override
	public Park getParkByParkCode(String parkCode) {
		return null;
	}

}
