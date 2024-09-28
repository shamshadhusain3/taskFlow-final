package com.app.taskflow.repository;

import com.app.taskflow.entity.User;
import org.springframework.data.repository.CrudRepository;


import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    User findByEmpId(String empId);

}
