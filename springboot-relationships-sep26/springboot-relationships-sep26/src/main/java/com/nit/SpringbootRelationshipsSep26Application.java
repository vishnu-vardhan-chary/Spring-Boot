package com.nit;

import java.awt.print.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nit.entity.Address;
import com.nit.entity.Student;
import com.nit.entity.Subject;
import com.nit.repository.StudentRepository;

@SpringBootApplication
public class SpringbootRelationshipsSep26Application  implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRelationshipsSep26Application.class, args);
	}

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		
		Student st1 = new Student("Kiran", "9988779988");
		Address add1 = new Address("Ameerpet", "Hyderabad");
		Subject sub1 = new Subject("Physics");
		Subject sub2 = new Subject("Chemistry");
		Subject sub3 = new Subject("Maths");
		st1.setAddress(add1);
		st1.getSubjects().add(sub1);
		st1.getSubjects().add(sub2);
		st1.getSubjects().add(sub3);
		st1 = studentRepository.save(st1);
		System.out.println(st1);
		
		Student st2 = new Student("Ravi", "9988777766");
		Address add2 = new Address("Nampally", "Hyderabad");
		Subject sub4 = new Subject("Botony");
		Subject sub5 = new Subject("Zoology");
		Subject sub6 = new Subject("History");
		st2.setAddress(add2);
		st2.getSubjects().add(sub4);
		st2.getSubjects().add(sub5);
		st2.getSubjects().add(sub6);
		st2 = studentRepository.save(st2);
		System.out.println(st2);
	}

}
