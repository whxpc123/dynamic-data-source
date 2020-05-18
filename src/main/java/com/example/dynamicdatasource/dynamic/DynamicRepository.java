package com.example.dynamicdatasource.dynamic;

import com.example.dynamicdatasource.entity.Stu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  DynamicRepository extends JpaRepository<Stu,Long> {
}