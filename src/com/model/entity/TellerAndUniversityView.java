package com.model.entity;


import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Mohammad on 24/12/2017.
 */
@Table(name = "TELLER_VIEW")
@Entity(name = "teller_view")
public class TellerAndUniversityView implements Serializable {


    @Id
    @Column(name = "TELLER_ID")
    private long tellerId;

    @Column(name = "TL_NAME",columnDefinition = "NVARCHAR2(20)")
    private String name;

    @Column(name = "TL_FAMILY",columnDefinition = "NVARCHAR2(20)")
    private String family;

    @Column(name = "TL_PASSWORD",columnDefinition = "NVARCHAR2(32)")
    private String pass;

    @Column(name = "UNI_FK_ID")
    private long uniId;

    @Column(name = "DELETED")
    private boolean deleted;

    @Column(name = "UNI_NAME",columnDefinition = "NVARCHAR2(20)")
    private String uniName;

    public TellerAndUniversityView() {
    }


    public long getTellerId() {
        return tellerId;
    }

    public void setTellerId(long tellerId) {
        this.tellerId = tellerId;
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

    public long getUniId() {
        return uniId;
    }

    public void setUniId(long uniId) {
        this.uniId = uniId;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public String getUniName() {
        return uniName;
    }

    public void setUniName(String uniName) {
        this.uniName = uniName;
    }
}
