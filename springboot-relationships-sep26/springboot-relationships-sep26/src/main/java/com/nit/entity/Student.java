package com.nit.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long stuId;
	private String stuName;
	private String phoneNumber;
	
	@OneToOne(cascade = CascadeType.ALL)
	//@JoinColumn(name = "address_id")
	@JoinTable(name = "student_address", joinColumns = @JoinColumn(name="stu_id"), inverseJoinColumns = @JoinColumn(name="address_id"))
	private Address address;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "student_subject", joinColumns = @JoinColumn(name="stu_id"), inverseJoinColumns = @JoinColumn(name="subject_id"))
	List<Subject> subjects = new ArrayList<>();
	
	public Student(String stuName, String phoneNumber) {
		this.stuName = stuName;
		this.phoneNumber = phoneNumber;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
