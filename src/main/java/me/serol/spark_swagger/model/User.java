package me.serol.spark_swagger.model;

import java.util.Collection;

public class User {
	private long id;
	private String name;
	private String lastname;
	private String phoneNumber;
	private BloodType bloodType;
	Collection<Donation> donations;

	Donation[] donations2;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public BloodType getBloodType() {
		return bloodType;
	}

	public void setBloodType(BloodType bloodType) {
		this.bloodType = bloodType;
	}

	public Collection<Donation> getDonations() {
		return donations;
	}

	public void setDonations(Collection<Donation> donations) {
		this.donations = donations;
	}

}
