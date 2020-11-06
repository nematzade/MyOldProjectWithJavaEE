package com.model.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by Mohammad on 24/12/2017.
 */

@Table(name = "UNI_VIEW")
@Entity(name = "uni_view")
public class UniversityAndUniView implements Serializable {

    @Id
    @Column(name = "UNI_ID")
    private long uniId;

    @Column(name = "UNI_NAME",columnDefinition = "NVARCHAR2(20)")
    private String uniName;

    @Column(name = "UNIVERSITY_FK_ID")
    private long universityId;


    @Column(name = "UNIVERSITY_NAME",columnDefinition = "NVARCHAR2(20)")
    private String universityName;

    @Column(name = "DELETED")
    private boolean deleted;

    public UniversityAndUniView() {
    }


    public long getUniId() {
        return uniId;
    }

    public void setUniId(long uniId) {
        this.uniId = uniId;
    }

    public String getUniName() {
        return uniName;
    }

    public void setUniName(String uniName) {
        this.uniName = uniName;
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
        this.universityName = universityName;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

}
