package com.project.reader.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.data.annotation.LastModifiedDate;


@MappedSuperclass
public abstract class AbstractModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(type = "integer", format = "int64")
    private Date createdAt = new Date();

    @Column(name = "created_by")
    private Long createdBy;

    @Column(name = "deleted_at")
    @Schema(type = "integer", format = "int64")
    private Date deletedAt;

    @LastModifiedDate
    @Schema(type = "integer", format = "int64")
    private Date lastModifiedDate = new Date();

    private Long deletedBy;

    private Long updatedBy;

    public AbstractModel() {

    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Date getDeletedAt() {
        return deletedAt == null ? new Date(0) : (deletedAt.getTime() < 0 ? new Date(0) : deletedAt);
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    public Long getDeletedBy() {
        return deletedBy;
    }

    public void setDeletedBy(Long deletedBy) {
        this.deletedBy = deletedBy;
    }

    public Long getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

}
