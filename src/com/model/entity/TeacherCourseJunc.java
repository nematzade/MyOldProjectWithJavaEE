package com.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Mohammad on 27/12/2017.
 */
@Table(name = "TEACHER_COURSE_JUNC")
@Entity(name = "teacher_course_junc")
public class TeacherCourseJunc implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tc_junc_seqId")
    @SequenceGenerator(name = "tc_junc_seqId", sequenceName = "tc_junc_seqId",allocationSize = 1)
    private long id;

    @Column(name = "TEACHER_ID")
    private long teacherId;

    @Column(name = "COURSE_ID")
    private long courseId;

    public TeacherCourseJunc() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
    }

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }
}
