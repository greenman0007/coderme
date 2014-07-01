package com.coderme.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ContactsDto implements Serializable {

	private static final long serialVersionUID = -2060586693004600263L;

	private Long id;
	
	private String mobileNumber;
	
	private String name;
	
	private String telephoneNumber;
	
	private String group;
	
	private String email;

	@XmlAttribute
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "ContactsDto [id=" + id + ", mobileNumber=" + mobileNumber
				+ ", name=" + name + ", telephoneNumber=" + telephoneNumber
				+ ", group=" + group + ", email=" + email + ", getId()="
				+ getId() + ", getMobileNumber()=" + getMobileNumber()
				+ ", getName()=" + getName() + ", getTelephoneNumber()="
				+ getTelephoneNumber() + ", getGroup()=" + getGroup()
				+ ", getEmail()=" + getEmail() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
}
