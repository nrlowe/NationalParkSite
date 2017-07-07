package com.techelevator;

import java.util.ArrayList;
import java.util.List;

import javax.activation.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCWeatherDAO implements WeatherDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCWeatherDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Weather> getWeatherByParkCode(String parkCode) {
		List<Weather> weatherList = new ArrayList<Weather>();
		String sqlSelectWeather = "SELECT * " + "FROM weather " + "WHERE parkCode=? ";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectWeather, parkCode);
		while(results.next()) {
			Weather weather = mapRowToWeather(results);			
			weatherList.add(weather);
		}
		return weatherList;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	private Weather mapRowToWeather(SqlRowSet row) {
		Weather weather = new Weather();
		weather.setParkCode(row.getString("parkCode"));
		weather.setFiveDayForecastValue(row.getInt("fiveDayForecastValue"));
		weather.setLow(row.getInt("low"));
		weather.setHigh(row.getInt("high"));
		weather.setForecast(row.getString("forecast"));
		return weather;
	}











	
	
	

}
