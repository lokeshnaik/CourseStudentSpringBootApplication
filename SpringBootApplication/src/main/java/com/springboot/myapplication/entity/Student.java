package com.springboot.myapplication.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;




@Entity
@Table(name="Student")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class,property="studentid")
public class Student 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="studentid")
	private int studentid;

	@Column(name="firstName")
	private String firstName;

	@Column(name="lastName")
	private String lastName;

	@Column(name="age")
	private int age;


	@Column(name="contactNumber",length=10)
	private String contactNumber;

	@ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},fetch = FetchType.LAZY)
	@JoinTable(name="Registration",joinColumns= @JoinColumn(name="studentid"),inverseJoinColumns = @JoinColumn(name="courseid"))
	private List<Course> course;

	public List<Course> getCourse() {
		return course;
	}



	public void setCourse(List<Course> course) {
		this.course = course;
	}



	public void add(Course tempcourse)
	{
		if(course==null)
		{
			course=new ArrayList<>();
		}
		course.add(tempcourse);
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




	public Student() {
		super();
	}



	public Student(int studentid, String firstName, String lastName, int age, String contactNumber) {
		super();
		this.studentid = studentid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.contactNumber = contactNumber;
	}




	@Override
	public String toString() {
		return "Student [studentid=" + studentid + ", firstName=" + firstName + ", lastName=" + lastName + ", age="
				+ age + ", contactNumber=" + contactNumber + "]";
	}




}
