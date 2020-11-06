package com.model.entity.auth;


import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Mohammad on 23/12/2017.
 */

@Table(name = "USERS")
@Entity(name = "USERS")
public class Users implements Serializable {

    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "user_seqId")
    @SequenceGenerator(name = "user_seqId", sequenceName = "user_seqId",allocationSize = 1)
    private long userId;

    @Column(name = "USERNAME",columnDefinition = "NVARCHAR2(20)")
    private String USERNAME;

    @Column(name = "PASSWORD",columnDefinition = "NVARCHAR2(32)")
    private String PASSWORD;

    public Users() {
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUSERNAME() {
        return USERNAME;
    }

    public void setUSERNAME(String USERNAME) {
        this.USERNAME = USERNAME.trim();
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD.trim();
    }
}
