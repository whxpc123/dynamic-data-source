package com.example.dynamicdatasource.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "stu")
@Data
public class Stu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Integer age;
}
