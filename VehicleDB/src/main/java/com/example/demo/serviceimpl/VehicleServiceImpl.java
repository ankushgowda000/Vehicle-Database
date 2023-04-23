package com.example.demo.serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.customexception.VehicleNotFoundException;
import com.example.demo.module.Vehicle;
import com.example.demo.repoOrdao.VehicleRepo;
import com.example.demo.service.VehicleService;

@Service
public class VehicleServiceImpl implements VehicleService {
	
	@Autowired
	VehicleRepo repo;

	@Override
	public Vehicle addVehicle(Vehicle v) {
		return repo.save(v);
	}

	@Override
	public Vehicle deleteById(Integer vId) {
		Vehicle v=repo.findById(vId).orElseThrow(null);
		if(v!=null) {
			repo.deleteById(vId);
			return v;
		}
		else {
			throw new VehicleNotFoundException("Vehicle", "id", vId); 
		}
	}

	@Override
	public List<Vehicle> getAllDetails() {
		return repo.findAll();
	}

	@Override
	public Vehicle getById(Integer vId) {
		return repo.findById(vId).orElseThrow(()-> new VehicleNotFoundException("Vehicle","id", vId));
	}

	@Override
	public List<Vehicle> getByColor(String vColor) {
		return repo.getByColor(vColor);
	}

	@Override
	public List<Vehicle> getSortedPrice() {
		return repo.SortedPrice();
	}

	@Override
	public List<Vehicle> getPriceGreaterThan() {
		return repo.getPriceGreaterThan();
	}

	@Override
	public List<Vehicle> getSortedPriceAndColor() {
		return repo.getSortedPriceAndColor();
	}

	@Override
	public Vehicle updateById(Vehicle v) {
		Vehicle v1= repo.findById(v.getvId()).orElse(null);
		if(v1!=null) {
			v1.setvModel(v.getvModel());
			v1.setvName(v.getvName());
			v1.setvColor(v.getvColor());
			v1.setvPrice(v.getvPrice());
			return repo.save(v1);
		}
		else {
			throw new VehicleNotFoundException("Vehicle", "id", v);
		}
	}

}
