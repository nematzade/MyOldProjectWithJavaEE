package com.model.service;


import com.model.entity.Teacher;
import com.model.entity.TeacherCourseJunc;
import com.model.entity.auth.UserRoles;
import com.model.entity.auth.Users;
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
public class TeacherService {

    @PersistenceContext
    EntityManager entityManager;

    public void persistUser(Teacher teacher)
    {

        Users user = new Users();
        user.setUSERNAME(teacher.getName());
        user.setPASSWORD(teacher.getPass());
        entityManager.persist(user);
    }

    public void persistUserRoles(Teacher teacher)
    {
        UserRoles userRoles = new UserRoles();
        userRoles.setUSERNAME(teacher.getName());
        userRoles.setROLE_NAME("teacher");
        entityManager.persist(userRoles);
    }

    public void removeJunc(long teacherId){

        List<TeacherCourseJunc> list = entityManager.createQuery("select o from teacher_course_junc o where o.teacherId=:x",
                TeacherCourseJunc.class)
                .setParameter("x",teacherId).getResultList();

        for (TeacherCourseJunc teacherCourseJunc : list) {
            entityManager.remove(teacherCourseJunc);
        }

    }

}
