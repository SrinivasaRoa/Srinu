package com.station.Station.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.station.Station.models.Station;


public interface StationRepository extends JpaRepository<Station,String>{

	Station findByStationId(String stationId);

	Station findByName(String name);

	List<Station> findByHdEnabled(Boolean hdEnabled);

	
}
