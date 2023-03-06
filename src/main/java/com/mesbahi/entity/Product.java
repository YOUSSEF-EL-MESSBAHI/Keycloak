package com.mesbahi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Product {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id ;
	private String name;
	private double price;
}
