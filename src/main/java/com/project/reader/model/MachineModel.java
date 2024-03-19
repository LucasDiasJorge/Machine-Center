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

    @Column(name = "manager", nullable = false)
    private String manager;

    @Column(name = "keep_alive",
            columnDefinition = "timestamp with time zone")
    @Temporal(TemporalType.TIMESTAMP)
    private Date keepAlive;

    @Column(name = "read_timeout", nullable = false,
            columnDefinition = "int default 2")
    private int readTimeout;

    @Column(name = "send_period", nullable = false,
            columnDefinition = "int default 5")
    private int sendPeriod;

    @Column(name = "model", nullable = false)
    private String model;

    @Column(name = "writer")
    private boolean writer;

    @Column(name = "product_id_writer")
    private Long productId;

    public MachineModel() {
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public boolean isWriter() {
        return writer;
    }

    public void setWriter(boolean writer) {
        this.writer = writer;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
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

    public int getReadTimeout() {
        return readTimeout;
    }

    public void setReadTimeout(int readTimeout) {
        this.readTimeout = readTimeout;
    }

    public int getSendPeriod() {
        return sendPeriod;
    }

    public void setSendPeriod(int sendPeriod) {
        this.sendPeriod = sendPeriod;
    }

}
