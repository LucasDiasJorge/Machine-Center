package com.project.reader.services;

import com.project.reader.model.ConfigModel;
import com.project.reader.model.MachineModel;
import org.springframework.stereotype.Service;

import com.project.reader.repository.ConfigRepository;

@Service
public class ConfigService {

    public final ConfigRepository repository;

    public ConfigService(ConfigRepository repository) {
        this.repository = repository;
    }


    public String getConfig(String serial) {
        return "config";
    }

    public String saveConfig(String config, MachineModel portalModel){
        ConfigModel configModel = new ConfigModel();
        configModel.setJsonConfig(config);
        configModel.setPortalModel(portalModel);
        repository.save(configModel);
        return configModel.getJsonConfig();
    }

    public String getDestination(String serial) {
        return "url";
    }
}
