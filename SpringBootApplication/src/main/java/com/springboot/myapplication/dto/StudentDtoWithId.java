package com.springboot.myapplication.dto;

public class StudentDtoWithId 
{

	private int studentid;

	private String firstName;

	private String lastName;

	private int age;

	private String contactNumber;



	public StudentDtoWithId() {
		super();
	}



	public StudentDtoWithId(int studentid, String firstName, String lastName, int age, String contactNumber) {
		super();
		this.studentid = studentid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.contactNumber = contactNumber;
	}


	public int getStudentid() {
		return studentid;
	}

	public void setStudentid(int studentid) {
		this.studentid = studentid;
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
		return "StudentDto [studentid=" + studentid + ", firstName=" + firstName + ", lastName=" + lastName + ", age="
				+ age + ", contactNumber=" + contactNumber + "]";
	}


}

