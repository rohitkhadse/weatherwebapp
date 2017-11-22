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
	public Weather findOne(String id) {
		Weather existing  = repository.findOne(id);
		if (existing == null) {
			throw new NotFoundException("Weather with id "+ id + "does not exist");
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
	public Weather update(String id, Weather user) {
		Weather existing  = repository.findOne(id);
		
		if (existing != null ) {
			throw new NotFoundException("Weather with id "+ id + "does not exist");
		}
		
		return repository.update( user);
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

}
