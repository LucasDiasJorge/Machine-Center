package com.project.reader.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Audited(auditParents = {AbstractModel.class})
@Table(name = "TB_CONFIG")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConfigModel extends AbstractModel{

    @Column(length = 1000)
    private String jsonConfig;

    @Column(length = 64)
    private String destination;

    @OneToOne()
    @JoinColumn(name = "machine_id", referencedColumnName = "id")
    private MachineModel machineModel;

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setMachineModel(MachineModel machineModel) {
        this.machineModel = machineModel;
    }

    public String getJsonConfig() {
        return jsonConfig;
    }

    public void setJsonConfig(String jsonConfig) {
        this.jsonConfig = jsonConfig;
    }

    public MachineModel getMachineModel() {
        return machineModel;
    }

    public void setPortalModel(MachineModel machineModel) {
        this.machineModel = machineModel;
    }
}
