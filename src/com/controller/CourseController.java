package com.controller;

import com.model.entity.Course;
import com.model.entity.Teacher;
import com.model.entity.TeacherCourseJunc;
import com.model.service.CourseService;
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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Mohammad on 25/12/2017.
 */

@Controller
@RequestMapping(value = "courseController")
public class CourseController {

    @Autowired
    CourseService courseService;

    @Autowired
    GenericRepository<Course> genericRepository;

    @RequestMapping(value = "/persist")
    @ResponseBody
    public void persist(HttpServletRequest request, @ModelAttribute Course course)
    {
        String[] teacherId = request.getParameterValues("teacher");
        courseService.persist(course,teacherId,request);

    }

    @RequestMapping(value = "/read")
    @ResponseBody
    public List<Course> read(HttpServletRequest request,@ModelAttribute Course course)
    {
        List<Course> courseList =  courseService.read(request);
        request.getSession().setAttribute("courseList",courseList);
        return courseList;
    }

    @RequestMapping(value = "/update")
    @ResponseBody
    public void update(HttpServletRequest request, @ModelAttribute Course course){

        String[] teacherId = request.getParameterValues("teacher");

        String courseId = request.getParameter("courseId");
        long courseID = Long.parseLong(courseId);

        Course findCourse = genericRepository.find(Course.class,courseID);
        findCourse.setName(course.getName());
        findCourse.setUnit(course.getUnit());
        findCourse.setCapacity(course.getCapacity());

        courseService.update(findCourse,teacherId);
    }


    @RequestMapping(value = "/delete")
    @ResponseBody
    public void delete(HttpServletRequest request, HttpServletResponse response, @RequestParam long courseId){

        courseService.delete(courseId,request);
        try {
            response.sendRedirect("/view/course/defineCourse.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

//***********************************************UTIL****************
    @RequestMapping(value = "/getTagBox")
    @ResponseBody
    public List getTagBox(){
        List<Teacher> list = courseService.getTagBox();
        return list;
    }

}
