package com.example.Haulage.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class HaulageItems {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private Double length;
	private Double width;
	private Double height;
	private Double Volumetric_Weight;
	private Double weight;
	private Boolean fragile;

	@ManyToOne
	@JoinColumn(name="haulage_id")
	Haulage haulage;

	public Double getLength() {
		return length;
	}

	public void setLength(Double length) {
		this.length = length;
	}

	public Double getWidth() {
		return width;
	}

	public void setWidth(Double width) {
		this.width = width;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public Double getVolumetric_Weight() {
		return Volumetric_Weight;
	}

	public void setVolumetric_Weight(Double volumetric_Weight) {
		Volumetric_Weight = volumetric_Weight;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Boolean getFragile() {
		return fragile;
	}

	public void setFragile(Boolean fragile) {
		this.fragile = fragile;
	}

	public Haulage getHaulage() {
		return haulage;
	}

	public void setHaulage(Haulage haulage) {
		this.haulage = haulage;
	}

}
