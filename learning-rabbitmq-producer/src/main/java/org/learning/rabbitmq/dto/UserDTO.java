package org.learning.rabbitmq.dto;

import java.io.Serializable;

public class UserDTO implements Serializable {
	private static final long serialVersionUID = -45405178149753529L;
	private String id;
	private String name;
	private String phoneNumber;

	public UserDTO() {
	}

	public UserDTO(String id, String name, String phoneNumber) {
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", phoneNumber=" + phoneNumber + "]";
	}
}
