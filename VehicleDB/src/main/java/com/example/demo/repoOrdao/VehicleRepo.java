package com.example.demo.repoOrdao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.demo.module.Vehicle;

public interface VehicleRepo extends JpaRepository<Vehicle, Integer>{
	
	@Query(value="select * from Vehicle where v_color=?1",nativeQuery = true)
	List<Vehicle> getByColor(String vColor);
	
	@Query(value="select * from Vehicle order by v_price asc",nativeQuery = true)
	List<Vehicle> SortedPrice();
	
	@Query(value="select * from Vehicle where v_price>1000000",nativeQuery = true)
	List<Vehicle> getPriceGreaterThan();
	
	@Query(value="select * from Vehicle order by v_price asc,v_color asc",nativeQuery = true)
	List<Vehicle> getSortedPriceAndColor();
	
	
	
	
}
