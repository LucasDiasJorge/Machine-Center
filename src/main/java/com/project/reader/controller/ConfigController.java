package com.project.reader.controller;

import javax.validation.Valid;

import com.project.reader.dto.Response;
import com.project.reader.model.MachineModel;
import com.project.reader.util.ResponseUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.reader.services.ConfigService;

@RestController
@RequestMapping("/config")
public class ConfigController {

    private final ConfigService configService;

    public ConfigController(ConfigService configService) {
        this.configService = configService;
    }

    @GetMapping("/{serial}")
    public String getMachineConfig(@PathVariable String serial){
        return configService.getConfig(serial);
    }

    @GetMapping("/destination/{serial}")
    public String getMachineDestination(@PathVariable String serial){
        return configService.getDestination(serial);
    }

    @PostMapping("/{serial}")
    public ResponseEntity<Response<String>> save(@Valid @RequestBody String config, @PathVariable String serial){

        MachineModel machineModel = null;
        String configModel = configService.saveConfig(config,machineModel);
        return ResponseUtil.createResponse(configModel, 201, "201 CREATED");
    }
}
