package com.project.reader.services;

import com.project.reader.model.ConfigModel;
import com.project.reader.model.MachineModel;
import com.project.reader.repository.MachineRepository;
import org.springframework.stereotype.Service;

import com.project.reader.repository.ConfigRepository;

@Service
public class ConfigService {

    public final ConfigRepository repository;
    public final MachineRepository machineRepository;

    public ConfigService(ConfigRepository repository, MachineRepository machineRepository) {
        this.repository = repository;
        this.machineRepository = machineRepository;
    }

    public ConfigModel getConfig(String serial) {
        return repository.findByMachine(machineRepository.findBySerial(serial).getId());
    }


    public ConfigModel getConfig(MachineModel machineModel) {
        return repository.findByMachine(machineModel.getId());
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
