package com.model.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * Created by Mohammad on 22/01/2018.
 */

@MappedSuperclass
public class BaseEntity implements Serializable{

    @Column(name = "DELETED")
    private Boolean deleted;

    @Column(name = "CREATED_BY",columnDefinition = "NVARCHAR2(20)")
    private String createdBy;

//    private TIMESTAMP createdDate;
    @Column(name = "DELETED_BY",columnDefinition = "NVARCHAR2(20)")
    private String deletedBy;

    public BaseEntity() {
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getDeletedBy() {
        return deletedBy;
    }

    public void setDeletedBy(String deletedBy) {
        this.deletedBy = deletedBy;
    }


}
