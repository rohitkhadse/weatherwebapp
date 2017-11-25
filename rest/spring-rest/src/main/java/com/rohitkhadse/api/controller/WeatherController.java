package com.rohitkhadse.api.controller;

import java.util.List;


import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rohitkhadse.api.constant.URI;

import com.rohitkhadse.api.entity.Weather;

import com.rohitkhadse.api.service.WeatherService;

@Component
@ResponseBody

@RestController
@RequestMapping(value = "cities")
public class WeatherController {

	private WeatherService service;
	
	public WeatherController(WeatherService service) {
		this.service = service;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Weather> findAll(){
		
		return service.findAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/allcity")
	public List<String> allCities(){
//		List<Weather> list = service.allCities();
//		list.forEach(city->System.out.println(city));
	
		return service.allCities();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "{city}")
	public Weather findOne(@PathVariable("city") String city){
		return service.findOne(city);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "{city}/temperature")
	public List<Weather> findProperty(@PathVariable("city") String city){
		return service.findProperty(city);
	}
	
	
	@RequestMapping(method = RequestMethod.GET, value = "{city}/humidity")
	public List<Weather> findHumidity(@PathVariable("city") String city){
		return service.findHumidity(city);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "{city}/pressure")
	public List<Weather> findPressure(@PathVariable("city") String city){
		return service.findPressure(city);
	}
	

	@RequestMapping(method = RequestMethod.GET, value = "{city}/wind")
	public String findWindSpeed(@PathVariable("city") String city){
		return service.findWindSpeed(city);
	}
	
	@RequestMapping(method = RequestMethod.POST )
	public Weather create(@RequestBody Weather user){
		return service.create(user);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = URI.ID)
	public Weather update(@PathVariable("id")String id,@RequestBody Weather user){
		return service.update(id, user);
	}
	

	@RequestMapping(method = RequestMethod.DELETE, value = URI.ID)
	public void delete(String id){
		service.delete(id);
	}
}

