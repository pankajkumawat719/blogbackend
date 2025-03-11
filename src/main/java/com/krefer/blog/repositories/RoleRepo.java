package com.krefer.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.krefer.blog.entity.Role;

public interface RoleRepo  extends JpaRepository<Role, Integer>{

}
