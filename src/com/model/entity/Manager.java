package com.model.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by Mohammad on 20/12/2017.
 */

@Table(name = "MANAGER")
@Entity(name = "manager")
public class Manager extends BaseEntity {

    @Id
    @Column(name = "MANAGER_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqId")
    @SequenceGenerator(name = "seqId", sequenceName = "seqId",allocationSize = 1)
    private long managerId;

    @Size(min = 1, max = 20)
    @NotNull(message = "in field nemitavanad khali bashad")
    @NotEmpty(message = "in field nemitavanad khali bashad")
    @Column(name = "NAME",columnDefinition = "NVARCHAR2(20)")
    private String name;

    @Size(min = 1, max = 20)
    @NotNull(message = "in field nemitavanad khali bashad")
    @NotEmpty(message = "in field nemitavanad khali bashad")
    @Column(name = "FAMILY",columnDefinition = "NVARCHAR2(20)")
    private String family;

    @Size(min = 1, max = 32)
    @NotNull(message = "in field nemitavanad khali bashad")
    @NotEmpty(message = "in field nemitavanad khali bashad")
    @Column(name = "PASSWORD",columnDefinition = "NVARCHAR2(32)")
    private String pass;

    @Column(name = "UNI_FK_ID")
    private long uniId;

    public Manager() {
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

    public long getUniId() {
        return uniId;
    }

    public void setUniId(long uniId) {
        this.uniId = uniId;
    }


}
