package com.model.entity.auth;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Mohammad on 23/12/2017.
 */
@Table(name = "USER_ROLES")
@Entity(name = "USER_ROLES")
public class UserRoles implements Serializable {

    @Id
    @Column(name = "USER_ROLES_ID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "user_roles_seqId")
    @SequenceGenerator(name = "user_roles_seqId", sequenceName = "user_roles_seqId",allocationSize = 1)
    private long userRolesId;

    @Column(name = "ROLE_NAME",columnDefinition = "NVARCHAR2(20)")
    private String ROLE_NAME;

    @Column(name = "USERNAME",columnDefinition = "NVARCHAR2(20)")
    private String USERNAME;


    public long getUserRolesId() {
        return userRolesId;
    }

    public void setUserRolesId(long userRolesId) {
        this.userRolesId = userRolesId;
    }

    public UserRoles() {
    }

    public String getROLE_NAME() {
        return ROLE_NAME;
    }

    public void setROLE_NAME(String ROLE_NAME) {
        this.ROLE_NAME = ROLE_NAME.trim();
    }

    public String getUSERNAME() {
        return USERNAME;
    }

    public void setUSERNAME(String USERNAME) {
        this.USERNAME = USERNAME.trim();
    }
}
