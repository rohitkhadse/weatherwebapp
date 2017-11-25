package com.rohitkhadse.api.repository;

import java.util.List;


import com.rohitkhadse.api.entity.Weather;

public interface WeatherRepository {
	
	public List<Weather> findAll();
	
	public Weather findOne(String city);
	
	public List<Weather> findProperty(String city);
	
	public List<Weather> findHumidity(String city);
	
	public List<Weather> findPressure(String city);
	
	public List<String> allCities();
	
	public Weather create(Weather weather);
	
	public Weather update(Weather weather);
	
	public void delete(Weather weather);

	public String findWindSpeed(String city);
}
