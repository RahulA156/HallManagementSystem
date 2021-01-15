package com.altimetrik.hall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.altimetrik.hall.model.Hall;
import com.altimetrik.hall.service.HallService;

@CrossOrigin("*")
@RestController
public class HallController {

	@Autowired
	private HallService service;

	@PostMapping("/saveHall")
	public @ResponseBody Object insertHall(@RequestBody Hall h) {
		return service.saveHall(h);

	}

	@GetMapping("/getAllHall")
	public @ResponseBody List<Hall> getHall() {
		return service.getAllHall();
	}

	@GetMapping("/getSingleHall/{name}")
	public @ResponseBody Object getHallByName(@PathVariable String name) {
		return service.getSingleHall(name);
	}
	
	@GetMapping("/getHallById/{id}")
	public @ResponseBody Object getHallById(@PathVariable int id) {
		return service.getSingleHallById(id);
	}

	@PutMapping("/updateHall/{id}")
	public @ResponseBody Object updateHall(@RequestBody Hall h,@PathVariable int id) {
		
		return (service.updateEmail(h));

	}

	@DeleteMapping("/deleteHall/{name}")
	public @ResponseBody Object deleteByName(@PathVariable String name) {
		return (service.deleteHallName(name));

	}
	
	@DeleteMapping("/deleteHallById/{id}")
	public @ResponseBody Object deleteById(@PathVariable int id) {
		return (service.deleteHallId(id));

	}

}
