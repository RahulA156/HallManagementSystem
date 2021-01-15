package com.altimetrik.hall.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import com.altimetrik.hall.model.Hall;
import com.altimetrik.hall.repository.HallRepo;
import com.mysql.cj.util.StringUtils;

@Service
public class HallServiceImpl implements HallService {

	@Autowired
	private HallRepo repo;

	@Override
	@Transactional
	public Object saveHall(Hall h) {
		Map<String, Object> mp = new HashMap<>();
		String a = String.valueOf(h.getHallFare());

		if (h.getHallName().trim().isEmpty()) {
			mp.put("Status", "1");
			mp.put("Message", "Name Should Not Be Empty");

		} else if (StringUtils.isStrictlyNumeric(h.getHallName())) {
			mp.put("Status", "1");
			mp.put("Message", "Please Enter The Valid Hall Name");
		} else if (!Pattern.matches("[a-zA-Z0-9 ]+", h.getHallName())) {
			mp.put("Status", "1");
			mp.put("Message", "Hall Name Should Not Contain any Special Characters");
		}
		else if (h.getHallOwnerName().trim().isEmpty()) {
			mp.put("Status", "2");
			mp.put("Message", "Owner Name Should Not Be Empty");
		} else if (StringUtils.isStrictlyNumeric(h.getHallOwnerName())) {
			mp.put("Status", "2");
			mp.put("Message", "Please Enter The Valid Hall Owner Name");
		} else if (!Pattern.matches("[a-zA-Z ]+", h.getHallOwnerName())) {
			mp.put("Status", "2");
			mp.put("Message", "Hall Owner Name Should Not Contain any Numbers or Special Characters");
		} else if (h.getOwnerEmailId().trim().isEmpty()) {
			mp.put("Status", "3");
			mp.put("Message", "Email Should Not Be Empty");
		}

		else if (!Pattern.matches("^([a-zA-Z0-9\\.-]+)@([a-zA-Z0-9-]+)\\.([a-z]{2,8})(.[a-z]{2,8})?$",
				h.getOwnerEmailId())) {
			mp.put("Status", "3");
			mp.put("Message", "Enter Valid Email Id");
		} else if (h.getOwnerMobile().trim().isEmpty()) {
			mp.put("Status", "4");
			mp.put("Message", "Mobile Number Should Not Be Empty");
		} else if (!Pattern.matches("^[7-9][0-9]{9}$", h.getOwnerMobile())) {
			mp.put("Status", "4");
			mp.put("Message", "Enter Valid Mobile Number");
		} else if (!StringUtils.isStrictlyNumeric(a) || a.length() == 0) {
			mp.put("Status", "5");
			mp.put("Message", "Hall Fare need to be numeric");
		}

		else {
			repo.save(h);
			mp.put("Status", "200");
			mp.put("Message", "Data Has been Successfully Added");
		}

		return mp;
	}

	@Override
	@Transactional
	public List<Hall> getAllHall() {

		return repo.findAll();
	}

	@Override
	@Transactional
	public Object getSingleHallById(int id) {
		Map<String, Object> mp = new HashMap<>();
		Hall h = repo.findById(id).orElse(null);
		if (h == null) {
			mp.put("Status", "1");
			mp.put("message", "Hall Id Not Found");
			return mp;

		} else {
			return ResponseEntity.ok(h);
		}
	}

	@Override
	@Transactional
	public Object getSingleHall(String name) {
		Map<String, Object> mp = new HashMap<>();
		Hall h = repo.findByHallName(name);
		if (h == null) {
			mp.put("Status", "1");
			mp.put("message", "Hall Name Not Found");
			return mp;

		} else {
			return ResponseEntity.ok(h);
		}
	}

	@Override
	@Transactional
	public Object updateEmail(Hall h) {
		int id=h.getId();
		String email=h.getOwnerEmailId();
		Hall g = repo.findById(id).orElse(null);
		Map<String, Object> mp = new HashMap<>();

		if (g == null) {
			mp.put("Status", "1");
			mp.put("Message", "Hall OwnerName Not Found");
			return mp;

		} else if (!Pattern.matches("^([a-zA-Z0-9\\.-]+)@([a-zA-Z0-9-]+)\\.([a-z]{2,8})(.[a-z]{2,8})?$", email)) {
			mp.put("Status", "2");
			System.out.println(email);
			mp.put("Message", "Enter Valid Email Id");
			return mp;
		} else {
			g.setOwnerEmailId(email);
			repo.save(g);
			mp.put("Status", "200");
			mp.put("Message", "Email Has been Updated Successfully");
			return mp;

		}

	}

	@Override
	@Transactional
	public Object deleteHallName(String name) {
		Map<String, Object> mp = new HashMap<>();
		Hall h = repo.findByHallName(name);

		if (StringUtils.isStrictlyNumeric(name)) {
			mp.put("Status", "1");
			mp.put("Message", "Please Enter The Valid Hall Name To Delete");
		} else if (h == null) {
			mp.put("Status", "2");
			mp.put("message", "Hall Name Not Found");
		}

		else {
			repo.deleteByHallName(name);
			mp.put("Status", "200");
			mp.put("Message", "Hall Has been Deleted Successfully");
		}

		return mp;
	}

	@Override
	@Transactional
	public Object deleteHallId(int id) {
		Map<String, Object> mp = new HashMap<>();
		Hall h = repo.findById(id).orElse(null);
		
		if (h==null) {
			mp.put("Status", "1");
			mp.put("message", "Hall id Not Found");
		}

		else {
			repo.deleteById(id);
			mp.put("Status", "200");
			mp.put("Message", "Hall Has been Deleted Successfully");
		}

		return mp;
	}

	@Override
	public Object updateById(int id,Hall hall) {
		Map<String, Object> mp = new HashMap<>();
		Hall h = repo.findById(id).orElse(null);
		if (h == null) {
			mp.put("Status", "1");
			mp.put("message", "Hall Id Not Found");
			return mp;

		} else {
			h.setHallName(hall.getHallName());
			h.setHallOwnerName(hall.getHallOwnerName());
			h.setOwnerEmailId(hall.getOwnerEmailId());
			h.setOwnerMobile(hall.getOwnerMobile());
			h.setHallFare(hall.getHallFare());
			repo.save(h);
			return ResponseEntity.ok(h);
		}
	}

}
