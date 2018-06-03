package com.xiu.sb.first.controller;

import com.xiu.sb.first.entity.Student;
import com.xiu.sb.first.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 学生控制层
 *
 * Created by bysocket on 24/07/2017.
 */
@Controller
@RequestMapping(value = "/students")     // 通过这里配置使下面的映射都在 /studentsstudent
public class StudentController {

    @Autowired
    StudentService studentService;          // 学生服务层

    /**
     *  获取学生列表
     *    处理 "/tudents" 的 GET 请求，用来获取s列表
     *    通过 @RequestParam 传递参数，进一步实现条件查询或者分页查询
     */
    @RequestMapping(method = RequestMethod.GET)
    public String getStudentList(ModelMap map) {
        map.addAttribute("studentList", studentService.findStudents());
        return "studentList";
    }

    /**
     * 显示创建学生表单
     *
     */
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createStudentForm(ModelMap map) {
        map.addAttribute("student", new Student());
        map.addAttribute("action", "create");
        return "studentForm";
    }

    /**
     *  创建学生
     *    处理 "/Students" 的 POST 请求，用来获取学生列表
     *    通过 @ModelAttribute 绑定参数，也通过 @RequestParam 从页面中传递参数
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String postStudent(@ModelAttribute Student student, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
          System.out.println(bindingResult.getAllErrors());
        }
        studentService.addStudent(student);
        return "redirect:/students/";
    }

    /**
     * 显示需要更新学生表单
     *    处理 "/Students/{id}" 的 GET 请求，通过 URL 中的 id 值获取 Student 信息
     *    URL 中的 id ，通过 @PathVariable 绑定参数
     */
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String getStudent(@PathVariable Integer id, ModelMap map) {
        map.addAttribute("student", studentService.findStudentById(id));
        map.addAttribute("action", "update");
        return "studentForm";
    }

    /**
     * 处理 "/Students/{id}" 的 PUT 请求，用来更新 Student 信息
     *
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String putStudent(@ModelAttribute Student student) {
        studentService.updateStudent(student);
        return "redirect:/students/";
    }

    /**
     * 处理 "/Students/{id}" 的 GET 请求，用来删除 Student 信息
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteStudent(@PathVariable Integer id) {

        studentService.delStudent(id);
        return "redirect:/students/";
    }

}