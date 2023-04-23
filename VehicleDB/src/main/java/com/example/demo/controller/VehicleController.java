package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.module.Vehicle;
import com.example.demo.service.VehicleService;

@RestController
public class VehicleController {
	
	@Autowired
	VehicleService ser;
	
	@PostMapping("addVehicle")
	ResponseEntity<Vehicle> addVehicle(@RequestBody Vehicle v){
		return new ResponseEntity<Vehicle>(ser.addVehicle(v),HttpStatus.CREATED);
	}
	
	@DeleteMapping("deleteById")
	ResponseEntity<Vehicle> deleteById(@RequestParam Integer vId){
		return new ResponseEntity<Vehicle>(ser.deleteById(vId),HttpStatus.OK);
	}
	
	@GetMapping("getAllDetails")
	ResponseEntity<List<Vehicle>> getAllDetails(){
		return new ResponseEntity<List<Vehicle>>(ser.getAllDetails(),HttpStatus.FOUND);
	}
	
	@GetMapping("getById")
	ResponseEntity<Vehicle> getById(@RequestHeader Integer vId){
		return new ResponseEntity<Vehicle>(ser.getById(vId),HttpStatus.FOUND);
	}
	
	@GetMapping("getByColor")
	ResponseEntity<List<Vehicle>> getByColor(@RequestHeader String vColor){
		return new ResponseEntity<List<Vehicle>>(ser.getByColor(vColor),HttpStatus.FOUND);
	}
	
	@GetMapping("getSortedPrice")
	ResponseEntity<List<Vehicle>> getSortedprice(){
		return new ResponseEntity<List<Vehicle>>(ser.getSortedPrice(),HttpStatus.FOUND);
	}
	
	@GetMapping("getPriceGreaterThan")
	ResponseEntity<List<Vehicle>> getpriceGretaerThan(){
		return new ResponseEntity<List<Vehicle>>(ser.getPriceGreaterThan(),HttpStatus.FOUND);
	}
	
	@GetMapping("getSortedPriceAndColor")
	ResponseEntity<List<Vehicle>> getSortedPriceAndColor(){
		return new ResponseEntity<List<Vehicle>>(ser.getSortedPriceAndColor(),HttpStatus.FOUND);
	}
	
	
	@PutMapping("updateById")
	ResponseEntity<Vehicle> updateById(@RequestBody Vehicle v){
		return new ResponseEntity<Vehicle>(ser.updateById(v),HttpStatus.FOUND);
	}
	
	
}
