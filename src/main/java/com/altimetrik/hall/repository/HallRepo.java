package com.altimetrik.hall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.altimetrik.hall.model.Hall;
@Repository
public interface HallRepo extends JpaRepository<Hall, Integer>{
	
	@Query("from Hall where hall_name like %?1%")
	Hall findByHallName(String name);
	
	@Query("from Hall where hall_owner_name like %?1%")
	Hall findByHallOwnerName(String name);
	
	@Modifying
	@Query("delete from Hall where hall_name = ?1")
	void deleteByHallName(String name);

}
