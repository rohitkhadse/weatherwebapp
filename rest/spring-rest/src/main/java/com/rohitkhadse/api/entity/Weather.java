package com.rohitkhadse.api.entity;

import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;


@Entity
@NamedQueries({
	@NamedQuery(name="Weather.findAll" , query="SELECT u FROM Weather u ORDER BY u.city"),
	@NamedQuery(name="Weather.allCities" , query = "SELECT DISTINCT(u.city) FROM Weather u"),
	@NamedQuery(name="Weather.findCity" , query = "SELECT u FROM Weather u WHERE u.city = :p ORDER BY u.timestamp DESC"),
	@NamedQuery(name="Weather.findProperty" , query = "SELECT u.city,u.temperature FROM Weather u WHERE u.city = :p "
			+ "ORDER BY u.timestamp DESC"),
	@NamedQuery(name="Weather.findHumidity" , query = "SELECT u.city,u.humidity FROM Weather u WHERE u.city = :p "
			+ "ORDER BY u.timestamp DESC"),
	@NamedQuery(name="Weather.findPressure" , query = "SELECT u.city,u.pressure FROM Weather u WHERE u.city = :p "
			+ "ORDER BY u.timestamp DESC"),

//	@NamedQuery(name="Weather.findWindSpeed" , query = "SELECT w.speed,w.degree FROM Wind w where w.id IN"
//			+ "(select u.wind_id from Weather u where u.city = :p ORDER BY u.timestamp DESC)"),
	@NamedQuery(name="Weather.findh" , query = "SELECT u.city,AVG(u.temperature),AVG(u.pressure),AVG(u.humidity) "
			+ "FROM Weather u WHERE u.timestamp = :p ORDER BY u.timestamp DESC")
	
})
public class Weather {
	
	@Id
	private String id;
	private String city;
	private int humidity;
	private int pressure;
	private int temperature;
	
	@OneToOne(cascade = {CascadeType.ALL})
	private Wind wind;
	
	private Timestamp timestamp;
	
	public Weather(){
		this.id = UUID.randomUUID().toString();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getHumidity() {
		return humidity;
	}
	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}

	public int getPressure() {
		return pressure;
	}

	public void setPressure(int pressure) {
		this.pressure = pressure;
	}

	public int getTemperature() {
		return temperature;
	}

	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}

	public Wind getWind() {
		return wind;
	}

	public void setWind(Wind wind) {
		this.wind = wind;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	
}
