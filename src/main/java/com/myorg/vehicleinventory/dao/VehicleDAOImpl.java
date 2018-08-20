package com.myorg.vehicleinventory.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myorg.vehicleinventory.entity.Vehicle;

@Repository
@Transactional
public class VehicleDAOImpl implements VehicleDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Vehicle> getAllVehicles() {
		List<Vehicle> vehicleList = sessionFactory.getCurrentSession().createQuery("from Vehicle").getResultList();
		return vehicleList;
	}

	@Override
	public Vehicle getVehicle(int id) {
		return sessionFactory.getCurrentSession().get(Vehicle.class, id);
	}

	@Override
	public void insertVehicle(Vehicle vehicle) {
		sessionFactory.getCurrentSession().save(vehicle);
	}

	@Override
	public void updateVehicle(Vehicle vehicle) {
		sessionFactory.getCurrentSession().update(vehicle);
	}

	@Override
	public void deleteVehicle(int id) {
		Vehicle vehicle = getVehicle(id);
		if (vehicle != null)
			sessionFactory.getCurrentSession().delete(vehicle);
	}

	@Override
	public Vehicle getLatestVehicle() {
		return (Vehicle) sessionFactory.getCurrentSession().createQuery("from Vehicle order by id desc").setMaxResults(1).uniqueResult();
	}

	@Override
	public void deleteLatestVehicle() {
		Vehicle vehicle = getLatestVehicle();
		if (vehicle != null) {
			sessionFactory.getCurrentSession().delete(vehicle);
		}
	}

}
