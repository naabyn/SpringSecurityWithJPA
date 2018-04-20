package com.nabin.SpringSecurityJpa.repository;

import com.nabin.SpringSecurityJpa.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<Role,Integer>{

}
