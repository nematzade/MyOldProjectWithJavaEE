package com.model.entity;


import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by Mohammad on 20/12/2017.
 */
@Table(name = "UNIVERSITY")
@Entity(name = "university")
public class University extends BaseEntity {

    @Id
    @Column(name = "UNIVERSITY_ID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "university_seqId")
    @SequenceGenerator(name = "university_seqId", sequenceName = "university_seqId",allocationSize = 1)
    private long universityId;

    @Size(min = 3, max = 20)
    @NotNull(message = "in field nemitavanad khali bashad")
    @NotEmpty(message = "in field nemitavanad khali bashad")
    @Column(name = "UNIVERSITY_NAME",columnDefinition = "NVARCHAR2(20)",unique = true)
    private String universityName;

    public University() {
    }


    public University(String universityName) {
        this.universityName = universityName.trim();
    }

    public long getUniversityId() {
        return universityId;
    }

    public void setUniversityId(long universityId) {
        this.universityId = universityId;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName.trim();
    }

}
