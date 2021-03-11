package com.mizan.main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Programmer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "programmer_name")
	private String name;
	private String language;
	public Programmer() {
		super();
	}
	public Programmer(int id, String name, String language) {
		super();
		this.id = id;
		this.name = name;
		this.language = language;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	@Override
	public String toString() {
		return "Programmer [id=" + id + ", name=" + name + ", language=" + language + "]";
	}
	
	
	
}
