package com.project.reader.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Audited(auditParents = {AbstractModel.class})
@Entity
@Table(name = "TB_CONFIG")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConfigModel extends AbstractModel{

    @Column(length = 1000)
    private String jsonConfig;

    @OneToOne()
    @JoinColumn(name = "portal_id")
    private MachineModel portalModel;

    public String getJsonConfig() {
        return jsonConfig;
    }

    public void setJsonConfig(String jsonConfig) {
        this.jsonConfig = jsonConfig;
    }

    public MachineModel getPortalModel() {
        return portalModel;
    }

    public void setPortalModel(MachineModel portalModel) {
        this.portalModel = portalModel;
    }
}
