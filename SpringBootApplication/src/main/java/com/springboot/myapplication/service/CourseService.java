package com.springboot.myapplication.service;

import java.util.List;

import com.springboot.myapplication.dto.CourseDto;
import com.springboot.myapplication.dto.CourseDtoWithId;
import com.springboot.myapplication.entity.Course;
import com.springboot.myapplication.exception.CourseException;
import com.springboot.myapplication.exception.StudentException;

public interface CourseService {

	public CourseDto addCourse(CourseDto course);

	public CourseDtoWithId getCourse(int id) throws CourseException;

	public List<CourseDtoWithId> getAllCourses();

	public CourseDtoWithId updateCourse(CourseDto course,int id)throws CourseException;

	public void deleteCourse(int id);

	public Course addStudentToCourse(int courseid,int studentid)throws CourseException,StudentException;
}
