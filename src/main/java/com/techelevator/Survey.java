package com.techelevator;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class Survey {
	@NotBlank(message="Please select a park")
	private String parkCode;
	
	@NotBlank(message="Please enter an email address")
	@Email(message="Please enter a valid email")
	private String email;
	
	@NotBlank(message="Please choose a state")
	private String state;
	
	@NotBlank(message="Please choose an activity level")
	private String activity;
	
	public String getParkCode() {
		return parkCode;
	}
	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getActivity() {
		return activity;
	}
	public void setActivity(String activity) {
		this.activity = activity;
	}
	
	
}
