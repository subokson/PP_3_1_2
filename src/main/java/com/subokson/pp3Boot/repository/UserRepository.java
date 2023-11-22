package com.subokson.pp3Boot.repository;

import com.subokson.pp3Boot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

}
