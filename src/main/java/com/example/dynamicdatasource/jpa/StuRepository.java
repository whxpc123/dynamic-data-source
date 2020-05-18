package com.example.dynamicdatasource.jpa;

import com.example.dynamicdatasource.entity.Stu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  StuRepository extends JpaRepository<Stu,Long> {
}
