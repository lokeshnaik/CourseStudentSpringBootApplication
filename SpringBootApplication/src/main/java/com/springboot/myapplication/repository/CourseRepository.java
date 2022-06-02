package com.springboot.myapplication.repository;

import java.util.List;
import java.util.Optional;

import com.springboot.myapplication.entity.Course;
import com.springboot.myapplication.exception.CourseException;

public interface CourseRepository 
{
	public Course addNewCourse(Course course);
	
	public Optional<Course>getCourseDetailById(int id);
	
	public List<Course> getAllCoursesAvailable();
	
	public Course updateCourseDetails(Course course,int id)throws CourseException;
	
	public void deleteWholeCourse(int id);
	
	public Course addStudentInCourse(int courseid,int studentid);

}
