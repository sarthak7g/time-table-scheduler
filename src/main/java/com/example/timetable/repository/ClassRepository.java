package com.example.timetable.repository;

import com.example.timetable.entity.Classs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRepository extends JpaRepository<Classs, Long> {
}
