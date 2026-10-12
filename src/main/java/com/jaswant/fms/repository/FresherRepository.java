package com.jaswant.fms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jaswant.fms.entity.Fresher;

@Repository
public interface FresherRepository extends JpaRepository<Fresher, Long> {

    Optional<Fresher> findByEmployeeId(String employeeId);

    Optional<Fresher> findByEmail(String email);

}