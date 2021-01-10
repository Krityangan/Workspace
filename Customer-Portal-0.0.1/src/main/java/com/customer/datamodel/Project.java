package com.customer.datamodel;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="project")
public class Project 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String projectName;
	
	private String projectIdentifier;
	
	private String description;
	
	private Date startDate;
	
	private Date endDate;
	
	private Date createdAt;
	private Date updatedAt;
	
	@PrePersist
	protected void onCreate()
	{
		this.createdAt=new Date();
	}
	
	@PreUpdate
	protected void onUpdate()
	{
		this.updatedAt=new Date();
	}
}
