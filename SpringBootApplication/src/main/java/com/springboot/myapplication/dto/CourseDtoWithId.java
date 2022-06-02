package com.springboot.myapplication.dto;

import java.time.LocalDate;


public class CourseDtoWithId 
{
	private int courseid;

	private String courseName;

	private long courseFee;

	private long courseDuration;

	private LocalDate courseStartdate;



	public CourseDtoWithId() {
		super();
	}



	public CourseDtoWithId(int courseid, String courseName, long courseFee, long courseDuration, LocalDate courseStartdate) {
		super();
		this.courseid = courseid;
		this.courseName = courseName;
		this.courseFee = courseFee;
		this.courseDuration = courseDuration;
		this.courseStartdate = courseStartdate;
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



	@Override
	public String toString() {
		return "CourseDto [courseid=" + courseid + ", courseName=" + courseName + ", courseFee=" + courseFee
				+ ", courseDuration=" + courseDuration + ", courseStartdate=" + courseStartdate + "]";
	}



}

