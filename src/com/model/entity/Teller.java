package com.model.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by Mohammad on 20/12/2017.
 */

@Table(name = "TELLER")
@Entity(name = "teller")
public class Teller extends BaseEntity {

    @Id
    @Column(name = "TELLER_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TL_seqId")
    @SequenceGenerator(name = "TL_seqId", sequenceName = "TL_seqId",allocationSize = 1)
    private long tellerId;

    @NotNull(message = "in field nemitavanad khali bashad")
    @NotEmpty(message = "in field nemitavanad khali bashad")
    @Column(name = "TL_NAME",columnDefinition = "NVARCHAR2(20)")
    private String name;

    @NotNull(message = "in field nemitavanad khali bashad")
    @NotEmpty(message = "in field nemitavanad khali bashad")
    @Column(name = "TL_FAMILY",columnDefinition = "NVARCHAR2(20)")
    private String family;

    @NotNull(message = "in field nemitavanad khali bashad")
    @NotEmpty(message = "in field nemitavanad khali bashad")
    @Column(name = "TL_PASSWORD",columnDefinition = "NVARCHAR2(32)")
    private String pass;

    @Column(name = "UNI_FK_ID")
    private long uniId;

    public Teller() {
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
