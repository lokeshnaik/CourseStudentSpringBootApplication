package com.springboot.myapplication.entity;

import java.time.LocalDate;
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


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name="course")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class,property="courseid")
public class Course 
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="courseid")
	private int courseid;

	@Column(name="courseName")
	private String courseName;

	@Column(name="courseFee")
	private long courseFee;


	@Column(name="courseDuration")
	private long courseDuration;

	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name="courseStartDate")
	private LocalDate courseStartdate;

	//@JsonIgnore
	//@JsonBackReference
	@ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},fetch = FetchType.LAZY)
	@JoinTable(name="Registration",joinColumns= @JoinColumn(name="courseid"),inverseJoinColumns = @JoinColumn(name="studentid"))
	private List<Student> student;

	public void add(Student tempstudent)
	{
		if(student==null)
		{
			student=new ArrayList<>();
		}

		student.add(tempstudent);
	}

	public List<Student> getStudent() {
		return student;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}


	public int getCourseid() {
		return courseid;
	}

	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public long getCourseFee() {
		return courseFee;
	}

	public void setCourseFee(long courseFee) {
		this.courseFee = courseFee;
	}

	public long getCourseDuration() {
		return courseDuration;
	}

	public void setCourseDuration(long courseDuration) {
		this.courseDuration = courseDuration;
	}

	public LocalDate getCourseStartdate() {
		return courseStartdate;
	}

	public void setCourseStartdate(LocalDate courseStartdate) {
		this.courseStartdate = courseStartdate;
	}

	public Course() {
		super();
	}

	public Course(int courseid, String courseName, long courseFee, long courseDuration, LocalDate courseStartdate) {
		super();
		this.courseid = courseid;
		this.courseName = courseName;
		this.courseFee = courseFee;
		this.courseDuration = courseDuration;
		this.courseStartdate = courseStartdate;
	}

	@Override
	public String toString() {
		return "Course [courseid=" + courseid + ", courseName=" + courseName + ", courseFee=" + courseFee
				+ ", courseDuration=" + courseDuration + ", courseStartdate=" + courseStartdate + "]";
	}


}
