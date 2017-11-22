package com.rohitkhadse.api.repository.impl;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;


import com.rohitkhadse.api.entity.Weather;

import com.rohitkhadse.api.repository.WeatherRepository;

@Repository
public class WeatherRepositoryImpl implements WeatherRepository{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Weather> findAll() {
		TypedQuery<Weather> query = em.createNamedQuery("Weather.findAll", Weather.class);
		return query.getResultList();
	}
	
	@Override
	public List<String> allCities() {
		
		TypedQuery<String> query = em.createNamedQuery("Weather.allCities", String.class);
		return query.getResultList();
		
	}

	@Override
	public Weather findOne(String id) {
		return em.find(Weather.class, id);
	}

	@Override
	public Weather create(Weather weather) {
		em.persist(weather);
		return weather;
	}

	@Override
	public Weather update( Weather weather) {
		
		return em.merge(weather);
	}

	@Override
	public void delete(Weather weather) {
		em.remove(weather);
		
	}

	
	
}
