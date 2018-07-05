package org.learning.thread.tradition.wait;

public class Phone {
	private String phone;
	private String serialNumber;

	public Phone(String phone, String serialNumber) {
		this.phone = phone;
		this.serialNumber = serialNumber;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	@Override
	public String toString() {
		return "Phone [phone=" + phone + ", serialNumber=" + serialNumber + "]";
	}
}
