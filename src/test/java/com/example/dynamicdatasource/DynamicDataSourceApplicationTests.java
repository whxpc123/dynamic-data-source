package com.example.dynamicdatasource;

import com.example.dynamicdatasource.dynamic.DynamicRepository;
import com.example.dynamicdatasource.entity.Stu;
import com.example.dynamicdatasource.jpa.StuRepository;
import com.example.dynamicdatasource.service.TestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class DynamicDataSourceApplicationTests {

	@Autowired
	private StuRepository repository;
	@Autowired
	private DynamicRepository dynamicRepository;
	@Autowired
	private TestService testService;

	@Test
	void contextLoads() {
	}

	@Test
	void stu() {
		Optional<Stu> optional = repository.findById(1203L);
		System.out.println(optional.get());
		System.out.println("-----------------------------");
		Optional<Stu> optional2 = dynamicRepository.findById(1L);
		System.out.println(optional2.get());
	}
	@Test
	void test() {
		Stu stu = testService.findById(1L);
		System.out.println(stu);
	}

}
