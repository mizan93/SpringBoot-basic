package com.mizan.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mizan.main.model.Programmer;

@Repository
public interface ProgrammerReport extends JpaRepository<Programmer, Integer> {

	@Query("from Programmer where language = ?1")
	List<Programmer> findP(String language);

}
