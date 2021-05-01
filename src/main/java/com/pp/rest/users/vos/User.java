package com.pp.rest.users.vos;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(description = "Users of Piedpiper rest service")
public class User {
	
	private int id;
	
	@ApiModelProperty(notes = "name should atleast have 2 characters")
	@Size(min=2,message = "name should have atleast two characters")
	private String name;
	
	@ApiModelProperty(notes = "Birth date should be in the past")
	@Past(message = "Birth date should be in the past")
	private Date dateOfBirth;
	
	
	public User(int id, String name, Date dateOfBirth) {
		super();
		this.id = id;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
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
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	


}
