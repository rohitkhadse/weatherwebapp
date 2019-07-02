package com.rohitkhadse.api.repository.impl;


import java.lang.reflect.Field;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.hibernate.dialect.function.VarArgsSQLFunction;
import org.springframework.stereotype.Repository;


import com.rohitkhadse.api.entity.Weather;
import com.rohitkhadse.api.entity.Wind;
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
	public Weather findOne(String city) {
		TypedQuery<Weather> query = em.createNamedQuery("Weather.findCity", Weather.class);
		query.setParameter("p", city);
		query.setMaxResults(1);
		return query.getSingleResult();
	}

	
	//to find temperature
	@Override
	public List<Weather> findProperty(String city) {
		TypedQuery<Weather> query = (TypedQuery<Weather>) em.createNamedQuery("Weather.findProperty");
		query.setParameter("p", city);
		query.setMaxResults(1);
		return query.getResultList();
	}
	
	public List<Weather> findHumidity(String city) {
		TypedQuery<Weather> query = (TypedQuery<Weather>) em.createNamedQuery("Weather.findHumidity");
		query.setParameter("p", city);
		query.setMaxResults(1);
		return query.getResultList();
	}
	
	public List<Weather> findPressure(String city) {
		TypedQuery<Weather> query = (TypedQuery<Weather>) em.createNamedQuery("Weather.findPressure");
		query.setParameter("p", city);
		query.setMaxResults(1);
		return query.getResultList();
	}
	
	@Override
	public String findWindSpeed(String city) {
		TypedQuery<Weather> query = (TypedQuery<Weather>) em.createQuery(""
				+ "select u.wind from Weather u where u.city = :p ORDER BY u.timestamp DESC");
		query.setParameter("p", city);
		query.setMaxResults(1);
		Object toRet = query.getSingleResult();
		
		String str = "";
		
		for (Field field : toRet.getClass().getDeclaredFields()) {
		    field.setAccessible(true); // You might want to set modifier to public first.
		    Object value = null;
			try {
				value = field.get(toRet);
			} catch (IllegalArgumentException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		    if (value != null) {
		        System.out.println(field.getName() + "=" + value);
		        //str += field.getName() + "=" + value;
		        if(field.getName() == "speed")
		        	str = String.valueOf(value);
		    }
		}
		
		return str.toString();
	}
	
	@Override
	public String findWindDegree(String city) {
		TypedQuery<Weather> query = (TypedQuery<Weather>) em.createQuery(""
				+ "select u.wind from Weather u where u.city = :p ORDER BY u.timestamp DESC");
		query.setParameter("p", city);
		query.setMaxResults(1);
		Object toRet = query.getSingleResult();
		
		String str = "";
		int degree = 0;
		
		for (Field field : toRet.getClass().getDeclaredFields()) {
		    field.setAccessible(true); // You might want to set modifier to public first.
		    Object value = null;
			try {
				value = field.get(toRet);
			} catch (IllegalArgumentException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		    if (value != null) {
		        System.out.println(field.getName() + "=" + value);
		        //str += field.getName() + "=" + value;
		        if(field.getName() == "degree")
		        	str = String.valueOf(value);
		    }
		}
		
		return str.toString();
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

	@Override
	public List<Object[]> findAVG(String city) {
		@SuppressWarnings("unchecked")
		TypedQuery<Object[]> query = (TypedQuery<Object[]>) em.createNamedQuery("Weather.findAVG");
		query.setParameter("p", city);
		query.setMaxResults(1);
		return query.getResultList();
	}	
	
}
