package com.project.reader.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;

import org.hibernate.envers.Audited;

import java.util.Date;

@Entity
@Audited(auditParents = {AbstractModel.class})
@Table(name = "TB_MACHINE", indexes = @Index(name = "idx_serial", columnList = "serial"))
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MachineModel extends AbstractModel {

    @Column(name = "start_date", nullable = false,
            columnDefinition = "timestamp with time zone not null")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;

    @Column(name = "renewal_date", nullable = false,
            columnDefinition = "timestamp with time zone not null")
    @Temporal(TemporalType.TIMESTAMP)
    private Date renewalDate;

    @Column(name = "expiration_date", nullable = false,
            columnDefinition = "timestamp with time zone not null")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expirationDate;

    @Column(name = "portal_status", nullable = false,
            columnDefinition = "int default 0")
    private int status = 0;

    @Column(name = "serial", nullable = false)
    private String serial;

    @Column(name = "keep_alive",
            columnDefinition = "timestamp with time zone")
    @Temporal(TemporalType.TIMESTAMP)
    private Date keepAlive;

    public MachineModel() {
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getRenewalDate() {
        return renewalDate;
    }

    public void setRenewalDate(Date renewalDate) {
        this.renewalDate = renewalDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public Date getKeepAlive() {
        return keepAlive;
    }

    public void setKeepAlive(Date keepAlive) {
        this.keepAlive = keepAlive;
    }

}
