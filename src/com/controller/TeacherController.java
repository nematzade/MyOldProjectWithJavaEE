package com.controller;


import com.model.entity.Course;
import com.model.entity.Teacher;
import com.model.service.TeacherService;
import com.model.util.GenericRepository;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Mohammad on 25/12/2017.
 */
@Controller
@RequestMapping(value = "teacherController")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @Autowired
    GenericRepository<Teacher> genericRepository;

    @RequestMapping(value = "/persist")
    @ResponseBody
    public Object persist(HttpServletRequest request, @ModelAttribute Teacher teacher)
    {
        genericRepository.persist(teacher,request);
        teacherService.persistUserRoles(teacher);
        teacherService.persistUser(teacher);
        return teacher;
    }

    @RequestMapping(value = "/read")
    @ResponseBody
    public List read(HttpServletRequest request, HttpServletResponse response, @ModelAttribute Teacher teacher)
    {
        List<Teacher> teachers =  genericRepository.read(Teacher.class);
        request.getSession().setAttribute("teacherList",teachers);
        return teachers;

    }


    @RequestMapping(value = "/update")
    @ResponseBody
    public void update(HttpServletRequest request, @ModelAttribute Teacher teacher){

        String id = request.getParameter("teacherId");
        Teacher find = genericRepository.find(Teacher.class,Long.parseLong(id));
        find.setName(teacher.getName());
        find.setFamily(teacher.getFamily());
        find.setPass(teacher.getPass());

        genericRepository.update(find);
    }

    @RequestMapping(value = "/delete")
    @ResponseBody
    public void delete(HttpServletRequest request,HttpServletResponse response,@RequestParam long teacherId){

        genericRepository.remove(Teacher.class,teacherId,request);
        teacherService.removeJunc(teacherId);
        try {
            response.sendRedirect("/view/teacher/defineTeacher.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
