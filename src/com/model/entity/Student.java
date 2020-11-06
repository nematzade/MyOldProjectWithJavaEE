package com.model.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by Mohammad on 20/12/2017.
 */

@Table(name = "STUDENT")
@Entity(name = "student")
public class Student extends BaseEntity {

    @Id
    @Column(name = "STUDENT_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ST_seqId")
    @SequenceGenerator(name = "ST_seqId", sequenceName = "ST_seqId",allocationSize = 1)
    private long studentId;

    @NotNull(message = "in field nemitavanad khali bashad")
    @NotEmpty(message = "in field nemitavanad khali bashad")
    @Column(name = "ST_NAME",columnDefinition = "NVARCHAR2(20)")
    private String name;

    @NotNull(message = "in field nemitavanad khali bashad")
    @NotEmpty(message = "in field nemitavanad khali bashad")
    @Column(name = "ST_FAMILY",columnDefinition = "NVARCHAR2(20)")
    private String family;

    @NotNull(message = "in field nemitavanad khali bashad")
    @NotEmpty(message = "in field nemitavanad khali bashad")
    @Column(name = "ST_PASSWORD",columnDefinition = "NVARCHAR2(32)")
    private String pass;


//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "STUDENT_COURSE_JUNC", joinColumns = { @JoinColumn(name = "STUDENT_ID") },
//            inverseJoinColumns = { @JoinColumn(name = "COURSE_ID") })
//    private Set<Course> coursess = new HashSet<Course>(0);


    public Student() {
    }

//    public Set<Course> getCoursess() {
//        return coursess;
//    }
//
//    public void setCoursess(Set<Course> coursess) {
//        this.coursess = coursess;
//    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.trim();
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family.trim();
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass.trim();
    }


}
