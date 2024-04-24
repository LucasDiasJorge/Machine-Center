package com.project.reader.model;

import javax.persistence.*;

import org.hibernate.envers.Audited;

import java.util.Date;

@Entity
@Audited(auditParents = {AbstractModel.class})
@Table(name = "TB_MACHINE")
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

    @Column(name = "serial", nullable = false, unique = true)
    private String serial;

    @Column(name = "keep_alive",
            columnDefinition = "timestamp with time zone")
    @Temporal(TemporalType.TIMESTAMP)
    private Date keepAlive;

    @Column(name = "out_antitheft")
    private boolean out;


    @Column(name = "in_antitheft")
    private boolean in;


    @Column(name = "get_config")
    private boolean getConfig;

    @Column(name = "config")
    private boolean config;

    @Column(name = "reboot")
    private boolean reboot;

    @Column(name = "read")
    private boolean read;

    @OneToOne(mappedBy = "machineModel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private ConfigModel configModel;

    public MachineModel() {
    }

    public ConfigModel getConfigModel() {
        return configModel;
    }

    public void setConfigModel(ConfigModel configModel) {
        this.configModel = configModel;
    }

    public boolean isIn() {
        return in;
    }

    public void setIn(boolean in) {
        this.in = in;
    }

    public boolean isOut() {
        return out;
    }

    public void setOut(boolean out) {
        this.out = out;
    }

    public boolean isGetConfig() {
        return getConfig;
    }

    public void setGetConfig(boolean getConfig) {
        this.getConfig = getConfig;
    }

    public boolean isConfig() {
        return config;
    }

    public void setConfig(boolean config) {
        this.config = config;
    }

    public boolean isReboot() {
        return reboot;
    }

    public void setReboot(boolean reboot) {
        this.reboot = reboot;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
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
