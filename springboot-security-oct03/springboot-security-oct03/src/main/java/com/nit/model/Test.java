package com.nit.model;

public class Test {

	public static void main(String[] args) {
		Student st = Student.builder()
				.id(1L)
				.name("Murty")
				.marks(600F)
				.build();
		System.out.println(st);

	}

}
