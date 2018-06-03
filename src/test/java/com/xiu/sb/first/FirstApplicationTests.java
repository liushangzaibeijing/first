package com.xiu.sb.first;

import com.xiu.sb.first.entity.Student;
import com.xiu.sb.first.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FirstApplication.class)
public class FirstApplicationTests {
	@Autowired
	private StudentService studentService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void addStudentTest(){
		Student student = new Student();
		student.setName("xieqx");
		student.setGrade(80.56f);
		student.setCost(1000.00);
		try {
			student.setBrithday(new SimpleDateFormat("yyyy-MM-dd").parse("1994-10-21"));
		} catch (ParseException e) {
			System.out.println("日期转换失败");
			e.printStackTrace();
		}
		studentService.addStudent(student);

		Student student2 = new Student();
		student2.setName(null);
		student2.setCost(1000.00);
		studentService.addStudent(student2);
	}



}
