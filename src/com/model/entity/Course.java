package com.model.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Mohammad on 20/12/2017.
 */

@Table(name = "COURSE")
@Entity(name = "course")
public class Course extends BaseEntity {

    @Id
    @Column(name = "COURSE_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "coursee_seqId")
    @SequenceGenerator(name = "coursee_seqId", sequenceName = "coursee_seqId",allocationSize = 1)
    private long courseId;

    @Size(min = 1, max = 20)
    @NotNull(message = "in field nemitavanad khali bashad")
    @NotEmpty(message = "in field nemitavanad khali bashad")
    @Column(name = "COURSE_NAME",columnDefinition = "NVARCHAR2(20)",unique = true)
    private String name;

    @Column(name = "COURSE_UNIT")
    private long unit;

    @Column(name = "CAPACITY")
    private long capacity;


    public Course() {
    }

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.trim();
    }

    public long getUnit() {
        return unit;
    }

    public void setUnit(long unit) {
        this.unit = unit;
    }

    public long getCapacity() {
        return capacity;
    }

    public void setCapacity(long capacity) {
        this.capacity = capacity;
    }

}
