package com.controller;


import com.model.entity.Course;
import com.model.entity.Student;
import com.model.service.StudentService;
import com.model.util.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Mohammad on 26/12/2017.
 */

@Controller
@RequestMapping(value = "studentController")
public class StudentController {

    @Autowired
    StudentService studentService;


    @RequestMapping(value = "/persist")
    @ResponseBody
    public Object persist(HttpServletRequest request,HttpServletResponse response,@ModelAttribute Student student) throws IOException {

        String[] courses = request.getParameterValues("course");

        long capacity = studentService.capacity(courses);

        if (capacity != 0) {

            studentService.persist(student, courses,request);

        }else {

            response.sendRedirect("/error.jsp");
        }

        return student;
    }


    @RequestMapping(value = "/read")
    @ResponseBody
    public List<Student> read(HttpServletRequest request, HttpServletResponse response, @ModelAttribute Student student)
    {
        List<Student> students =  studentService.read(request);
        request.getSession().setAttribute("studentList",students);
        return students;
    }

    @RequestMapping(value = "/update")
    @ResponseBody
    public void update(HttpServletRequest request, @ModelAttribute Student student){

        String[] teacherId = request.getParameterValues("course");

        String id = request.getParameter("studentId");
        Student find = studentService.findById(Long.parseLong(id));
        find.setName(student.getName());
        find.setFamily(student.getFamily());
        find.setPass(student.getPass());

        studentService.update(find,teacherId);

    }


    @RequestMapping(value = "/delete")
    @ResponseBody
    public void delete(HttpServletRequest request,HttpServletResponse response,@RequestParam long studentId){
        studentService.delete(studentId,request);
        try {
            response.sendRedirect("/view/student/defineStudent.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //***********************************************UTIL****************
    @RequestMapping(value = "/getTagBox")
    @ResponseBody
    public List getTagBox(){
        List<Course> list = studentService.getTagBox();
        return list;
    }


}
