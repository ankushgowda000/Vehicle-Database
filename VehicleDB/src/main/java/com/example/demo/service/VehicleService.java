package com.example.demo.service;

import java.util.List;

import com.example.demo.module.Vehicle;

public interface VehicleService {
	
	Vehicle addVehicle(Vehicle v);
	
	Vehicle deleteById(Integer vId);
	
	List<Vehicle> getAllDetails();
	
	Vehicle getById(Integer vId);
	
	List<Vehicle> getByColor(String vColor);
	
	List<Vehicle> getSortedPrice();
	
	List<Vehicle> getPriceGreaterThan();
	
	List<Vehicle> getSortedPriceAndColor();
	
	Vehicle updateById(Vehicle v);
}
