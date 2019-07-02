package com.rohitkhadse.api.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.rohitkhadse.api.entity.Weather;
import com.rohitkhadse.api.exception.NotFoundException;

import com.rohitkhadse.api.repository.WeatherRepository;

import com.rohitkhadse.api.service.WeatherService;

@Service
public class WeatherServiceImpl implements WeatherService{

	private WeatherRepository repository;
	
	public WeatherServiceImpl(WeatherRepository repository) {
		this.repository = repository;
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Weather> findAll() {
		return repository.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<String> allCities() {
		return repository.allCities();
	}

	@Override
	@Transactional(readOnly = true)
	public Weather findOne(String city) {
		Weather existing  = repository.findOne(city);
		if (existing == null) {
			throw new NotFoundException("Weather with city name="+ city + " does not exist");
		}
		return existing;
	}

	@Override
	@Transactional
	public Weather create(Weather weather) {
		
		return repository.create(weather);
	}

	@Override
	@Transactional
	public Weather update(String id, Weather weather) {
//		Weather existing  = repository.findOne(id);
//		
//		if (existing != null ) {
//			throw new NotFoundException("Weather with id "+ id + "does not exist");
//		}
		
		return repository.update( weather);
	}

	@Override
	@Transactional
	public void delete(String id) {
		Weather existing  = repository.findOne(id);
		
		if (existing != null ) {
			throw new NotFoundException("Weather with id "+ id + "does not exist");
		}
		repository.delete(existing);
	}

	@Override
	public List<Weather> findProperty(String city) {
		List<Weather> existing  = repository.findProperty(city);
		if (existing == null) {
			throw new NotFoundException("Weather with city name="+ city + " does not exist");
		}
		return existing;
	}
	
	@Override
	public List<Weather> findHumidity(String city) {
		List<Weather> existing  = repository.findHumidity(city);
		if (existing == null) {
			throw new NotFoundException("Weather with city name="+ city + " does not exist");
		}
		return existing;
	}

	@Override
	public List<Weather> findPressure(String city) {
		List<Weather> existing  = repository.findPressure(city);
		if (existing == null) {
			throw new NotFoundException("Weather with city name="+ city + " does not exist");
		}
		return existing;
	}

	@Override
	public String findWindSpeed(String city) {
		String existing  = repository.findWindSpeed(city);
		if (existing == null) {
			throw new NotFoundException("Weather with city name="+ city + " does not exist");
		}
		return existing;
	}

	@Override
	public String findWindDegree(String city) {
		String existing  = repository.findWindDegree(city);
		if (existing == null) {
			throw new NotFoundException("Weather with city name="+ city + " does not exist");
		}
		return existing;
	}

	@Override
	public List<Object[]> findAVG(String city) {
		List<Object[]> existing  = repository.findAVG(city);
		if (existing == null) {
			throw new NotFoundException("Weather with city name="+ city + " does not exist");
		}
		return existing;
	}
}
