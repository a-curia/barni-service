package com.infosys.barni.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infosys.barni.entity.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long>{

}