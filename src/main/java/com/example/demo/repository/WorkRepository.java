package com.example.demo.repository;

import com.example.demo.entity.Work;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface WorkRepository extends JpaRepository<Work, Integer> {
}
