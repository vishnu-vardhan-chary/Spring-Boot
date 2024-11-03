package com.nit.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.entity.MyUser;

public interface MyUserRepository extends JpaRepository<MyUser, Long>{
	Optional<MyUser> findByUserName(String abc);
}
