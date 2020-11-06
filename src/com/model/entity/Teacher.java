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

@Table(name = "TEACHER")
@Entity(name = "teacher")
public class Teacher extends BaseEntity {

    @Id
    @Column(name = "TEACHER_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TH_seqId")
    @SequenceGenerator(name = "TH_seqId", sequenceName = "TH_seqId",allocationSize = 1)
    private long teacherId;

    @NotNull(message = "in field nemitavanad khali bashad")
    @NotEmpty(message = "in field nemitavanad khali bashad")
    @Column(name = "TH_NAME",columnDefinition = "NVARCHAR2(20)")
    private String name;

    @NotNull(message = "in field nemitavanad khali bashad")
    @NotEmpty(message = "in field nemitavanad khali bashad")
    @Column(name = "TH_FAMILY",columnDefinition = "NVARCHAR2(20)")
    private String family;

    @NotNull(message = "in field nemitavanad khali bashad")
    @NotEmpty(message = "in field nemitavanad khali bashad")
    @Column(name = "TH_PASSWORD",columnDefinition = "NVARCHAR2(32)")
    private String pass;

    public Teacher() {
    }

    public long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
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
