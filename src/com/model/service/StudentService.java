package com.model.service;

import com.model.entity.Course;
import com.model.entity.Student;
import com.model.entity.StudentCourseJunc;
import com.model.entity.auth.UserRoles;
import com.model.entity.auth.Users;
import com.model.util.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Mohammad on 26/12/2017.
 */

@Service
@Transactional
public class StudentService {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    GenericRepository<Student> genericRepository;

    public void persist(Student student,String[] id,HttpServletRequest request)
    {
        genericRepository.persist(student,request);
        persistUser(student);
        persistUserRoles(student);
        for (String s : id) {
            createJunc(student.getStudentId(),Long.parseLong(s));
        }
    }



    public void persistUser(Student student)
    {
        Users user = new Users();
        user.setUSERNAME(student.getName());
        user.setPASSWORD(student.getPass());
        entityManager.persist(user);
    }

    public void persistUserRoles(Student student)
    {
        UserRoles userRoles = new UserRoles();
        userRoles.setUSERNAME(student.getName());
        userRoles.setROLE_NAME("student");
        entityManager.persist(userRoles);
    }

    public List<Student> read(HttpServletRequest request)
    {
        List<Student> studentList;
        studentList = genericRepository.read(Student.class);
        return studentList;
    }

    public void update(Student student,String[] id)
    {
        removeJunc(student.getStudentId());
        genericRepository.update(student);
        for (String s : id) {
            createJunc(student.getStudentId(),Long.parseLong(s));
        }
    }

    public Student findById(long id){
        return genericRepository.find(Student.class,id);
    }

    public void delete(long studentId,HttpServletRequest request)
    {
        genericRepository.remove(Student.class,studentId,request);
        removeJunc(studentId);
    }


    //    *****************************UTILL********************************

    public void createJunc(long studentId,long courseId)
    {
        StudentCourseJunc courseJunc = new StudentCourseJunc();
        courseJunc.setCourseId(courseId);
        courseJunc.setStudentId(studentId);
        entityManager.persist(courseJunc);
    }

    private void removeJunc(long id) {

        List<StudentCourseJunc> list = entityManager.createQuery("select o from student_course_junc o where o.studentId=:x",
                StudentCourseJunc.class)
                .setParameter("x",id).getResultList();

        for (StudentCourseJunc studentCourseJunc : list) {
            entityManager.remove(studentCourseJunc);

            capacityPlus(studentCourseJunc.getCourseId());
        }

    }

    public List getTagBox(){
        List<Course> courseList;
        courseList = entityManager.createQuery("select o from course o where o.deleted=:x",Course.class)
                .setParameter("x",false)
                .getResultList();
        return courseList;
    }

    //dar in method agar daneshjo darsi entekhb karde bashad yek vahed az an dars kam khahad shod.
    public long capacity(String[] id){
        long capacity = 0;
        for (String s : id) {
            long cId = Long.parseLong(s);
            Course find = entityManager.find(Course.class,cId);
            capacity = find.getCapacity();

            if (capacity != 0) {
                long cap = capacity - 1;
                find.setCapacity(cap);
                entityManager.merge(find);
            }

        }
        return capacity;
    }

    //dar in method agar daneshjo darsi ra hazf konad yek vahed be an dars afzode mishavad.
    public void capacityPlus(long id){
            long capacity = 0;

            Course find = entityManager.find(Course.class,id);
            capacity = find.getCapacity();

                long cap = capacity + 1;
                find.setCapacity(cap);
                entityManager.merge(find);

    }

}
