package com.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Mohammad on 27/12/2017.
 */
@Table(name = "STUDENT_COURSE_JUNC")
@Entity(name = "student_course_junc")
public class StudentCourseJunc implements Serializable {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "junc_seqId")
    @SequenceGenerator(name = "junc_seqId", sequenceName = "junc_seqId",allocationSize = 1)
    private long id;

    @Column(name = "STUDENT_ID")
    private long studentId;

    @Column(name = "COURSE_ID")
    private long courseId;

    public StudentCourseJunc() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }
}
