package com.customer.datamodel;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;


import lombok.Data;

@Data
@Entity
@Table(name="customer_basic")
public class Customer implements Serializable{

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("email")
	private String emailID;
	
	@JsonProperty("mobile")
	private String mobile;
	
	@JsonProperty("address")
	@OneToMany(fetch = FetchType.EAGER, targetEntity = Address.class, cascade = CascadeType.ALL)
	private List<Address> address;
	
	@JsonProperty("dob")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date dob;
	
	@JsonProperty("image")
	@OneToOne(fetch = FetchType.EAGER, targetEntity = Image.class, cascade = CascadeType.ALL)
	private Image image;
}
