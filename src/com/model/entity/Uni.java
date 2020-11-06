package com.model.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by Mohammad on 20/12/2017.
 */
@Table(name = "UNI")
@Entity(name = "uni")
public class Uni extends BaseEntity {

    @Id
    @Column(name = "UNI_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "uni_seqId")
    @SequenceGenerator(name = "uni_seqId", sequenceName = "uni_seqId" ,allocationSize = 1)
    private long uniId;

    @Size(min = 3, max = 20)
    @NotNull(message = "in feild nemitavanad khali bashad")
    @NotEmpty(message = "in feild nemitavanad khali bashad")
    @Column(name = "UNI_NAME",columnDefinition = "NVARCHAR2(20)")
    private String uniName;

    @Column(name = "UNIVERSITY_FK_ID")
    private long universityId;


    public Uni() {
    }

    public long getUniId() {
        return uniId;
    }

    public void setUniId(long uniId) {
        this.uniId = uniId;
    }

    public long getUniversityId() {
        return universityId;
    }

    public void setUniversityId(long universityId) {
        this.universityId = universityId;
    }

    public String getUniName() {
        return uniName;
    }

    public void setUniName(String uniName) {
        this.uniName = uniName.trim();
    }

}
