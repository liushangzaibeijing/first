package com.xiu.sb.first.service.impl;

import com.xiu.sb.first.dao.StudentReposity;
import com.xiu.sb.first.entity.Student;
import com.xiu.sb.first.service.StudentService;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentReposity studentReposity;

    @Override
    public boolean addStudent(Student student) {
        studentReposity.save(student);
        return true;
    }



    @Override
    public boolean updateStudent(Student student) {
        if(student.getId()!=null){
          studentReposity.save(student);
          return true;
        }
        return false;
    }

    @Override
    public Student findStudentById(Integer id) {
        Student student = studentReposity.findById(id).get();
        return student;
    }

    @Override
    public List<Student> findStudents() {
        return studentReposity.findAll();
    }

    @Override
    public boolean delStudent(Integer id) {
        Student student = new Student();
        student.setId(id);
        studentReposity.delete(student);
        return true;
    }
}
