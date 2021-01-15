package com.altimetrik.hall.service;

import java.util.List;

import com.altimetrik.hall.model.Hall;



public interface HallService {
	public Object saveHall(Hall h);
	public List<Hall> getAllHall();
	public Object getSingleHallById(int id);
	public Object getSingleHall(String name);
	public Object updateEmail(Hall h);
	public Object updateById(int h,Hall hall);
	public Object deleteHallName(String name);
	public Object deleteHallId(int id);
	

}
