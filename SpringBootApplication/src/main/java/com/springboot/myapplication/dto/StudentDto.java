package com.springboot.myapplication.dto;

public class StudentDto 
{
	private String firstName;

	private String lastName;

	private int age;

	private String contactNumber;



	public StudentDto() {
		super();
	}



	public StudentDto(String firstName, String lastName, int age, String contactNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.contactNumber = contactNumber;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	
	@Override
	public String toString() {
		return "StudentDto [ firstName=" + firstName + ", lastName=" + lastName + ", age="
				+ age + ", contactNumber=" + contactNumber + "]";
	}



}
