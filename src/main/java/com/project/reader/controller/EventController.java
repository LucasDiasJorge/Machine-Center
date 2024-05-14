package com.project.reader.controller;

import com.project.reader.exception.AppException;
import com.project.reader.model.MachineModel;
import com.project.reader.repository.MachineRepository;
import com.project.reader.services.ConfigService;
import com.project.reader.services.EventService;
import com.project.reader.services.MachineService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/event")
public class EventController {

    private final EventService service;
    private final MachineService machineService;
    private final ConfigService configService;

    public EventController(EventService service, MachineService machineService, ConfigService configService) {
        this.service = service;
        this.machineService = machineService;
        this.configService = configService;
    }

    @PreAuthorize("hasRole('MACHINE')")
    @GetMapping("/keepalive/{serial}")
    public Map<String,Object> keepalive(@PathVariable String serial, Principal principal) throws AppException {

        Map<String,Object> ret = new HashMap<>();

        Date now = new Date();

        MachineModel machine = machineService.findBySerial(serial);
        machine.setKeepAlive(now);
        machine.setIn(false);
        machine.setOut(false);
        machineService.update(machine.getId(),machine,principal);

        ret.put("In",machine.isIn() ? 1 : 0);
        ret.put("Out",machine.isOut() ? 1 : 0);
        ret.put("Config",machine.isGetConfig() ? 1 : 0);
        ret.put("Reboot",machine.isReboot() ? 1 : 0);
        ret.put("Read",machine.isRead() ? 1 : 0);
        ret.put("Filter",machine.getFilterTimeout());
        ret.put("Destination",configService.getConfig(machine).getDestination());

        return ret;

    }

    @PreAuthorize("hasRole('MACHINE')")
    @PutMapping("/in/{companyId}")
    public Map<String,Integer> in(@PathVariable Long companyId, Principal principal) throws AppException {

        Map<String,Integer> ret = new HashMap<>();

        List<MachineModel> machines = machineService.findByCompanyId(companyId);

        for (MachineModel machine:machines) {
            machine.setIn(true);
            machineService.update(machine.getId(),machine, principal);
        }

        return ret;

    }

    @PreAuthorize("hasRole('MACHINE')")
    @GetMapping("/out/{companyId}")
    public Map<String,Integer> out(@PathVariable Long companyId, Principal principal) throws AppException {
        Map<String,Integer> ret = new HashMap<>();

        List<MachineModel> machines = machineService.findByCompanyId(companyId);

        for (MachineModel machine:machines) {
            machine.setIn(true);
            machineService.update(machine.getId(),machine, principal);
        }

        return ret;

    }

    @PreAuthorize("hasRole('MACHINE')")
    @GetMapping("/reboot/{serial}")
    public Map<String,Integer> reboot(@PathVariable String serial) {

        Map<String,Integer> ret = new HashMap<>();

        MachineModel machine = machineService.findBySerial(serial);

        // Switcher
        machine.setReboot(!machine.isReboot());

        return ret;

    }

    @PreAuthorize("hasRole('MACHINE')")
    @GetMapping("/config/{serial}")
    public Map<String,Integer> config(@PathVariable String serial) {

        Map<String,Integer> ret = new HashMap<>();

        MachineModel machine = machineService.findBySerial(serial);

        // Switcher
        machine.setConfig(!machine.isConfig());

        return ret;

    }

}
