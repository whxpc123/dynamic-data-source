package com.example.dynamicdatasource.service;

import com.example.dynamicdatasource.annotation.DataSource;
import com.example.dynamicdatasource.annotation.DataSourceNames;
import com.example.dynamicdatasource.entity.Stu;
import com.example.dynamicdatasource.jpa.StuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service(value = "testService")
public class TestService {
    @Autowired
    private StuRepository repository;

    @DataSource(name = DataSourceNames.SECOND)
    public Stu findById(Long id){
        Optional<Stu> optional = repository.findById(id);
        if(optional.isPresent()){
            return optional.get();
        }
        return null;
    }

}
