package com.springboot.myapplication.dto;

import java.time.LocalDate;


public class CourseDto 
{
	private String courseName;

	private long courseFee;

	private long courseDuration;

	private LocalDate courseStartdate;



	public CourseDto() {
		super();
	}



	public CourseDto(String courseName, long courseFee, long courseDuration, LocalDate courseStartdate) {
		super();
		this.courseName = courseName;
		this.courseFee = courseFee;
		this.courseDuration = courseDuration;
		this.courseStartdate = courseStartdate;
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

	
	@Override
	public String toString() {
		return "CourseDto [ courseName=" + courseName + ", courseFee=" + courseFee
				+ ", courseDuration=" + courseDuration + ", courseStartdate=" + courseStartdate + "]";
	}





}
