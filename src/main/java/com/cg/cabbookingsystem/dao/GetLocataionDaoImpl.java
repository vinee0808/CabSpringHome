package com.cg.cabbookingsystem.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.cabbookingsystem.dto.CustomerRequest;
import com.cg.cabbookingsystem.dto.Location;

/**
 * Dao class containing two methods for fetching location details of source and destination
 * and fetching all locations names.
 * @author 
 *
 */
@Repository
public class GetLocataionDaoImpl implements GetLocationDao{

	@Autowired
	EntityManager mgr;
	
	/**
	 * This method fetches the Location Details of source and destination 
	 * given in the Trip Details from Location Entity.
	 * @param CustomerRequest
	 * @return List<Location> It returns list of Location objects
	 */
	@Override
	public List<Location> getLocationDetails(CustomerRequest details) {
		List<Location> journey = new ArrayList<Location>();
		Location source = mgr.createNamedQuery("getCoordinates",Location.class).setParameter("name", details.getSource()).getSingleResult();
		Location destination = mgr.createNamedQuery("getCoordinates", Location.class).setParameter("name", details.getDestination()).getSingleResult();
		
		journey.add(source);
		journey.add(destination);
		
		return journey;
	}

	/**
	 * This method fetches all location names from location Entity
	 * @param 
	 * @return List<String> List of Location Names
	 */
	@Override
	public List<String> listOfLocations() {
		List<Location> locationsDetails = mgr.createNamedQuery("getAllLocations", Location.class).getResultList();
		List<String> locations = new ArrayList<String>();
		for(Location location: locationsDetails)
			locations.add(location.getName());
		return locations;
	}

}
