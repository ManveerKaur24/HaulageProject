package com.example.Haulage.Entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Country {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotEmpty(message = "hey, sorry!, please fill this")
	private String countryName;

	@OneToMany(mappedBy = "country", targetEntity = State.class, cascade = CascadeType.ALL)
	List<State> list = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public List<State> getList() {
		return list;
	}

	public void setList(List<State> list) {
		this.list = list;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

}
