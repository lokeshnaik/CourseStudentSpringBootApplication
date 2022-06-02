package com.springboot.myapplication.repositoryimplementation;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.myapplication.entity.Student;
import com.springboot.myapplication.repository.StudentRepository;

@Repository
public class StudentRepositoryImp implements StudentRepository
{

    @Autowired
	private SessionFactory factory;

	@Override
	public Student addNewStudent(Student student) {
		Session session=factory.openSession();
		session.save(student);
		return student;
	}

	@Override
	public Optional<Student> getStudentDetailById(int id) {
		Session session=factory.openSession();
		Optional<Student>student=session.createQuery("from Student where id="+id,Student.class).uniqueResultOptional();
		return student;
	}

	@Override
	public List<Student> getAllStudentDetails() {
		Session session=factory.openSession();
		
		Query<Student> query=session.createQuery("from Student",Student.class);
		List<Student>student=query.getResultList();
		return student;
	}

	@Override
	public Student updateStudentDetails(Student student, int id) {
	
		Session session=factory.openSession();
		
		session.beginTransaction();
		Student student1=(Student)session.get(Student.class, id);

		student1.setFirstName(student.getFirstName());
		student1.setLastName(student.getLastName());
		student1.setAge(student.getAge());
		student1.setContactNumber(student.getContactNumber());
		session.update(student1);
		
		session.getTransaction().commit();
		session.close();
		return student1;
		
	}

	@Override
	public void deleteStudentById(int id) {
	Session session=factory.openSession();
	
	session.beginTransaction();
	Student student=session.get(Student.class, id);
	session.delete(student);
	
	session.getTransaction().commit();
	session.close();
	
	return ;	
	}
	
	
}
