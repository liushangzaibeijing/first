package com.xiu.sb.first.dao;

import com.xiu.sb.first.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * JPA持久化实体类
 */
public interface StudentReposity extends JpaRepository<Student,Integer> {


}
