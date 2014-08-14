package com.socar.hrsocar.model;

public class FmlItem {
	private String firstName;
	private String lastName;
	private String fatherName;
	private String birthday;
	private String type; //child or spouse
	public FmlItem() {
		super();
		this.firstName=null;
		this.lastName=null;
		this.fatherName=null;
		this.type =null;
		this.birthday=null;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

}
