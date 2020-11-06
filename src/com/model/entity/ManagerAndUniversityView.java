package com.model.entity;



import org.hibernate.validator.constraints.NotEmpty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by Mohammad on 24/12/2017.
 */

@Table(name = "MANAGER_VIEW")
@Entity(name = "manager_view")
public class ManagerAndUniversityView implements Serializable {

    @Id
    @Column(name = "MANAGER_ID")
    private long managerId;

//    @NotNull(message = "in field nemitavanad khali bashad")
//    @NotEmpty(message = "in field nemitavanad khali bashad")
    @Column(name = "NAME",columnDefinition = "NVARCHAR2(20)")
    private String name;

//    @NotNull(message = "in field nemitavanad khali bashad")
//    @NotEmpty(message = "in field nemitavanad khali bashad")
    @Column(name = "FAMILY",columnDefinition = "NVARCHAR2(20)")
    private String family;

//    @NotNull(message = "in field nemitavanad khali bashad")
//    @NotEmpty(message = "in field nemitavanad khali bashad")
    @Column(name = "PASSWORD",columnDefinition = "NVARCHAR2(32)")
    private String pass;

    @Column(name = "UNIVERSITY_FK_ID")
    private long universityId;

    @Column(name = "UNIVERSITY_NAME",columnDefinition = "NVARCHAR2(20)",unique = true)
    private String universityName;

    @Column(name = "DELETED")
    private boolean deleted;

    public ManagerAndUniversityView() {
    }

    public long getManagerId() {
        return managerId;
    }

    public void setManagerId(long managerId) {
        this.managerId = managerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
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
