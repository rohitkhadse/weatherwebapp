package com.rohitkhadse.api.repository;

import java.util.List;


import com.rohitkhadse.api.entity.Weather;

public interface WeatherRepository {
	
	public List<Weather> findAll();
	
	public Weather findOne(String id);
	
	public Weather create(Weather weather);
	
	public Weather update(Weather weather);
	
	public void delete(Weather weather);
}
