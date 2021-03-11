package com.mizan.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mizan.main.model.User;

@Repository
public interface UserReport extends JpaRepository<User, Integer> {

	List<User> findByName(String name);

}
