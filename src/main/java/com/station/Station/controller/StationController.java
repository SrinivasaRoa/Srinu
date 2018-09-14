package com.station.Station.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.station.Station.models.Station;
import com.station.Station.repo.StationRepository;

@Controller
public class StationController {

	@Autowired
	private StationRepository stationRepository;
	
	
	
	@RequestMapping(value = "/saveOrUpdateStation", method = RequestMethod.POST)
	@ResponseBody
	public Station saveOrUpdate(@RequestBody Station station){
		stationRepository.save(station);
		return station;
	}
	
	@RequestMapping(value = "/removeStation", method = RequestMethod.POST)
	@ResponseBody
	public Station remove(@RequestBody Station station){
		stationRepository.delete(station);
		return station;
	}
	
	@RequestMapping(value = "/searchByIDOrName", method = RequestMethod.POST)
	@ResponseBody
	public Station findById(@RequestBody Station station){
		Station stationS = null;
		if(station.getStationId()!=null)
			stationS = stationRepository.findByStationId(station.getStationId());
		else if(station.getName()!=null)
			stationS = stationRepository.findByName(station.getName());
		return stationS;
	}
	
	@RequestMapping(value = "/searchByHDEnabled", method = RequestMethod.POST)
	@ResponseBody
	public List<Station> findByHDEnabled(@RequestBody Station station){
		List<Station> stationList = stationRepository.findByHdEnabled(station.getHdEnabled());
		return stationList;
	}
	
	
}
