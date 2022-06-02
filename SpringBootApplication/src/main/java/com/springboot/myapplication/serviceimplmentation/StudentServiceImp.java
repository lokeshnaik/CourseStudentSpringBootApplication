package com.springboot.myapplication.serviceimplmentation;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.springboot.myapplication.dto.CourseDtoWithId;
import com.springboot.myapplication.dto.StudentDto;
import com.springboot.myapplication.dto.StudentDtoWithId;
import com.springboot.myapplication.entity.Course;
import com.springboot.myapplication.entity.Student;
import com.springboot.myapplication.exception.StudentException;
import com.springboot.myapplication.repository.StudentRepository;
import com.springboot.myapplication.service.StudentService;

@Service
@Transactional
public class StudentServiceImp implements StudentService
{

	@Autowired
	private StudentRepository studentRepository;
	
	
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public StudentDto addStudent(StudentDto student) {

		Student student1=modelMapper.map(student,Student.class);
	
		//Commented below lines to promote functional programming using ModelMapper
	/*	Student student1=new Student();
	    student1.setFirstName(student.getFirstName());
		student1.setAge(student.getAge());
		student1.setContactNumber(student.getContactNumber());
		student1.setLastName(student.getLastName());
	//	student1.setStudentid(student.getStudentid());*/
		
		studentRepository.addNewStudent(student1);
		return student;
	}

	@Override
	public StudentDtoWithId getStudent(int id) throws StudentException  {
	//	StudentDtoWithId stud=new StudentDtoWithId();
		Student student=studentRepository.getStudentDetailById(id).orElseThrow(()->new StudentException("Student with the given id is not available in the list",HttpStatus.NOT_FOUND));
		StudentDtoWithId stud=modelMapper.map(student,StudentDtoWithId.class);
		
		//Commented below lines to promote functional programming using ModelMapper
	/*	stud.setAge(student.getAge());
		stud.setContactNumber(student.getContactNumber());
		stud.setFirstName(student.getFirstName());
		stud.setLastName(student.getLastName());
		stud.setStudentid(student.getStudentid());*/
		
		return stud;
	}

	@Override
	public List<StudentDtoWithId> getAllStudents() {
		List<StudentDtoWithId>stud=new ArrayList<>();
		List<Student> student=studentRepository.getAllStudentDetails();
		
		for(Student stu:student)
		{
			StudentDtoWithId studo=modelMapper.map(stu, StudentDtoWithId.class);
			
			//Commented below lines to promote functional programming using ModelMapper
		/*	StudentDtoWithId studo=new StudentDtoWithId();
			studo.setAge(stu.getAge());
			studo.setContactNumber(stu.getContactNumber());
			studo.setFirstName(stu.getFirstName());
			studo.setLastName(stu.getLastName());
			studo.setStudentid(stu.getStudentid());*/
			stud.add(studo);
		}
		return stud;
	}

	@Override
	public StudentDtoWithId updateStudent(StudentDto student, int id) {
		
		
		Student student1=modelMapper.map(student,Student.class);
		//Commented below lines to promote functional programming using ModelMapper
	/*	Student student1=new Student();
		student1.setAge(student.getAge());
		student1.setContactNumber(student.getContactNumber());
		student1.setFirstName(student.getFirstName());
		student1.setLastName(student.getLastName());
		student1.setStudentid(id);*/
		
		
		
		Student student2=studentRepository.updateStudentDetails(student1,id);
		
		StudentDtoWithId stud=modelMapper.map(student2,StudentDtoWithId.class);
		//StudentDtoWithId stud=new StudentDtoWithId();
		//Commented below lines to promote functional programming using ModelMapper
	/*	Student student2=new Student();
		stud.setAge(student2.getAge());
		stud.setContactNumber(student2.getContactNumber());
		stud.setFirstName(student2.getFirstName());
		stud.setLastName(student2.getLastName());
		stud.setStudentid(id);*/
	
		return stud;
	}

	@Override
	public void deleteStudent(int id) {
		// TODO Auto-generated method stub
		studentRepository.deleteStudentById(id);
		return ;
	}

}
