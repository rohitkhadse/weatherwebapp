package com.rohitkhadse.api.service;

import java.util.List;

import com.rohitkhadse.api.entity.Weather;

public interface WeatherService {

	public List<Weather> findAll();
	
	public List<String> allCities();
	
	public Weather findOne(String city);
	
	public Weather create(Weather weather);
	
	public Weather update(String id, Weather weather);
	
	public void delete(String id);
}
