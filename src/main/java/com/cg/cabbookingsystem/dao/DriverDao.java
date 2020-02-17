package com.cg.cabbookingsystem.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.cabbookingsystem.dto.Driver;

public interface DriverDao extends JpaRepository<Driver, Integer> {

	@Query("Select d FROM Driver d WHERE d.email=:email AND d.password=:password")
	Driver getDriver(String email, String password);
	@Query("Select d FROM Driver d WHERE d.email=:email")
	Driver getDriver(String email);

}
