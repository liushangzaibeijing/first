package com.xiu.sb.first.service;

import com.xiu.sb.first.entity.Student;
import org.springframework.validation.BindingResult;

import javax.validation.Valid;
import java.util.List;

public interface StudentService {

    boolean addStudent(Student student);

    boolean updateStudent(Student student);

    Student findStudentById(Integer id);

    List<Student> findStudents();

    boolean delStudent(Integer id);


}
