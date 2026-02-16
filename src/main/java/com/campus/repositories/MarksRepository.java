package com.campus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.campus.entities.Marks;

@Repository
public interface MarksRepository extends JpaRepository<Marks, Long> {
}