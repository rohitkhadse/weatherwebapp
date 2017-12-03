package com.rohitkhadse.api.service;

import java.util.List;

import com.rohitkhadse.api.entity.Weather;

public interface WeatherService {

	public List<Weather> findAll();
	
	public List<String> allCities();
	
	public Weather findOne(String city);
	
	public List<Weather> findProperty(String city);
	
	public List<Weather> findHumidity(String city);
	
	public List<Weather> findPressure(String city);
	
	public Weather create(Weather weather);
	
	public Weather update(String id, Weather weather);
	
	public void delete(String id);

	public String findWindSpeed(String city);
	
	public String findWindDegree(String city);
	
	public List<Object[]> findAVG(String city);
}
