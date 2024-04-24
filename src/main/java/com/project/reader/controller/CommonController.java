package com.project.reader.controller;

import com.project.reader.exception.AppException;
import com.project.reader.model.ConfigModel;
import com.project.reader.model.MachineModel;
import com.project.reader.repository.ConfigRepository;
import com.project.reader.repository.MachineRepository;
import com.project.reader.services.MachineService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/machine")
public class CommonController {

    private final ConfigRepository configRepository;
    private final MachineRepository machineRepository;
    private final MachineService machineService;

    public CommonController(ConfigRepository configRepository, MachineRepository machineRepository, MachineService machineService) {
        this.configRepository = configRepository;
        this.machineRepository = machineRepository;
        this.machineService = machineService;
    }


    @GetMapping("/ping")
    public String ping(){

        return " MACHINE CENTER is running ... ";

    }

    @GetMapping("/populate")
    public String populate() throws AppException {

        Date now = new Date();

        MachineModel machine = new MachineModel();

        machine.setIn(false);
        machine.setOut(false);
        machine.setConfig(false);
        machine.setReboot(false);
        machine.setGetConfig(true);
        machine.setRead(true);
        machine.setKeepAlive(now);
        machine.setStartDate(now);
        machine.setExpirationDate(now);
        machine.setRenewalDate(now);
        machine.setCreatedBy(1L);
        machine.setSerial("001625159088");

        machineService.save(machine);

        ConfigModel config = new ConfigModel();

        config.setJsonConfig("JSON CONFIG");
        config.setDestination("http://localhost:8891/api/v2/reader");
        config.setPortalModel(machine);

        configRepository.save(config);

        return " MACHINE CENTER is populated ... ";

    }

}
