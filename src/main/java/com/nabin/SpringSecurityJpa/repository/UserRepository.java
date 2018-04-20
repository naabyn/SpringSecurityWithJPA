package com.nabin.SpringSecurityJpa.repository;

import com.nabin.SpringSecurityJpa.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<Users,Integer> {
}
