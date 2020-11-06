package com.model.service;

import com.model.entity.Course;
import com.model.entity.Teacher;
import com.model.entity.TeacherCourseJunc;
import com.model.util.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Mohammad on 25/12/2017.
 */

@Service
@Transactional
public class CourseService {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    GenericRepository<Course> genericRepository;

    public void persist(Course course,String[] id,HttpServletRequest request){

        genericRepository.persist(course,request);

        for (String s : id) {
            createJunc(course.getCourseId(),Long.parseLong(s));
        }

    }

    public List<Course> read(HttpServletRequest request)
    {
        List<Course> courseList;
        courseList = (List<Course>) entityManager.createQuery("select o from course o where o.deleted=:x")
                .setParameter("x",false).getResultList();
        return courseList;
    }

    public void update(Course course,String[] teacherId){

        removeJunc(course.getCourseId());

        genericRepository.update(course);

        for (String s : teacherId) {
            createJunc(course.getCourseId(),Long.parseLong(s));
        }


    }

    public List getTagBox(){
        List<Teacher> teacherList;
        teacherList = (List<Teacher>) entityManager.createQuery("select o from teacher o where o.deleted=:x").setParameter("x",false).getResultList();
        return teacherList;
    }

    public void delete(long courseId,HttpServletRequest request)
    {
        genericRepository.remove(Course.class,courseId,request);
        removeJunc(courseId);
    }

//    *****************************UTILL********************************

    public void createJunc(long courseId,long teacherId)
    {
        TeacherCourseJunc teacherCourseJunc = new TeacherCourseJunc();
        teacherCourseJunc.setCourseId(courseId);
        teacherCourseJunc.setTeacherId(teacherId);
        entityManager.persist(teacherCourseJunc);
    }


    private void removeJunc(long id) {

        List<TeacherCourseJunc> list = entityManager.createQuery("select o from teacher_course_junc o where o.courseId=:x",
                TeacherCourseJunc.class)
                .setParameter("x",id).getResultList();

        for (TeacherCourseJunc teacherCourseJunc : list) {
            entityManager.remove(teacherCourseJunc);
        }

    }

}
