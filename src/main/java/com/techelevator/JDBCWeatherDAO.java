package com.techelevator;

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
