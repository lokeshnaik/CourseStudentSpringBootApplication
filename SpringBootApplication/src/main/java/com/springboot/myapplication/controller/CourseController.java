package com.springboot.myapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.myapplication.dto.CourseDto;
import com.springboot.myapplication.dto.CourseDtoWithId;
import com.springboot.myapplication.entity.Course;
import com.springboot.myapplication.exception.CourseException;
import com.springboot.myapplication.exception.StudentException;
import com.springboot.myapplication.response.CourseResponse;
import com.springboot.myapplication.service.CourseService;

@RestController
@RequestMapping("/education/course")
public class CourseController 
{
	@Autowired
	private CourseService courseService;

/*	@Autowired
	private StudentService studentService;*/
	

	/**This API is adding new course to 
	 * And it is taking CourseDto as input
	 * @RequestBody course as a input
	 * Return Success or Failure*/
	@PostMapping("/addcourse")
	private ResponseEntity<CourseResponse> addCourse(@RequestBody CourseDto course)
	{
		course=courseService.addCourse(course);
		return ResponseEntity.status(HttpStatus.CREATED).body(new CourseResponse("Course is added",201,course));
	}
	
	
	/**This API is getting  course available
	 * And it is taking id as input
	 * @PathVariable id as a input
	 * Return Success or Failure*/
	@GetMapping("/getcourse/{id}")
	private ResponseEntity<CourseResponse> getCourse(@PathVariable int id) throws CourseException
	{
		CourseDtoWithId course=courseService.getCourse(id);

		//Commented below lines to promote functional programming using Optional
	/*	if(!course.isPresent())
		{

		//	System.out.println("Course with id "+id+" is not available"); 
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new CourseResponse("Course with id "+id+" is not available",404));
		}
		else
		{*/

		return ResponseEntity.status(HttpStatus.OK).body(new CourseResponse("Got Course of desired given id",200,course)); 
	//	}
	}
	
	/**This API is getting all courses available
	 * Returning all the available course in list*/
	@GetMapping("/getallcourses")
	private ResponseEntity<CourseResponse> getAllCourses()
	{
		List<CourseDtoWithId> course=courseService.getAllCourses(); 
		return ResponseEntity.status(HttpStatus.OK).body(new CourseResponse("Got all the available course in the list",200,course));
	}

	/**This API is updating  course available
	 * And it is taking course and id as input
	 * @RequestBody course and @PathVariable id as a input
	 * Return Success or Failure*/
	@PutMapping("/updatecourse/{id}")
	private ResponseEntity<CourseResponse> updateCourse(@RequestBody CourseDto course,@PathVariable int id) throws Exception,CourseException
	{
	//	CourseDtoWithId course2=courseService.getCourse(id);
	/*	if(course2==null)
		{
			throw new Exception("Course of given id "+id+" is not available to update");
		}*/

		CourseDtoWithId course1=courseService.updateCourse(course,id);
		return ResponseEntity.status(HttpStatus.OK).body(new CourseResponse("Course of given id="+id+" is updated",200,course1));  
	}
	
	/**This API is deleting  course available
	 * And it is taking id as input
	 * @PathVariable id as a input
	 * Return Success or Failure*/
	@DeleteMapping("/deletecourse/{id}")
	private ResponseEntity<CourseResponse> deleteCourse(@PathVariable int id) throws CourseException
	{
		CourseDtoWithId course=courseService.getCourse(id);
		//Commented below lines to promote functional programming using Optional
	/*	if(course==null)
		{
			String string="The id which you entered "+id+" is not avaibale in the database to delete";
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new CourseResponse(string,404,null));
		}*/
		courseService.deleteCourse(course.getCourseid());
		String string1="The course contain id which you entered "+id+" got  deleted from the database";
		return ResponseEntity.status(HttpStatus.OK).body(new CourseResponse(string1,204,null));
	}
	
	/**This API is adding and mapping course available with student available
	 * And it is taking courseid  and studentid as input
	 * @PathVariable courseid and  @PathVariable studentid as a input
	 * Return Success or Failure*/
	@PostMapping("/{courseid}/{studentid}")
	private ResponseEntity<CourseResponse> AssignStudentToCourse(@PathVariable int courseid,@PathVariable int studentid) throws CourseException, StudentException
	{
		//Commented below lines to promote functional programming using Optional
	/*	CourseDtoWithId course=courseService.getCourse(courseid);
			
		if(course==null)
		{
			String string="The id which you entered "+courseid+" is not avaibale in the database to delete";
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new CourseResponse(string,404,null));
		}
		
		StudentDtoWithId student=studentService.getStudent(studentid);*/

		//Commented below lines to promote functional programming using Optional
	/*	if(student==null)
		{
			String string1="The id which you entered "+studentid+" is not avaibale in the database to delete";
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new CourseResponse(string1,404,null));   
		}*/
		Course course1=courseService.addStudentToCourse(courseid, studentid);
		return ResponseEntity.status(HttpStatus.CREATED).body(new CourseResponse("Assigned Student to the course",201,course1));
	}
}
