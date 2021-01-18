package com.customer.datamodel;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Entity
@Table(name="customer_basic_details")
public class Customer implements Serializable {


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonProperty("c_name")
	private String name;
	
	@JsonProperty("c_email")
	private String emailID;
	
	@JsonProperty("mobile")
	@OneToMany(fetch = FetchType.EAGER,targetEntity = Mobile.class,cascade = CascadeType.ALL)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Mobile> mobile;

	@JsonProperty("address")
	@OneToMany(fetch = FetchType.EAGER, targetEntity = Address.class, cascade = CascadeType.ALL)
	private List<Address> address;
	
	@JsonProperty("dob")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date dob;
	
	@JsonProperty("image")
	@OneToMany(fetch = FetchType.EAGER, targetEntity = ImageFile.class, cascade = CascadeType.ALL)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<ImageFile> image;
	
}
