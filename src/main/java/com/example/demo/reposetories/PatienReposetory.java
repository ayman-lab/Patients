package com.example.demo.reposetories;

import com.example.demo.entites.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatienReposetory  extends JpaRepository<Patient,Long> {
    public Page<Patient> findByNomContains(String mc , Pageable pageable);
}
