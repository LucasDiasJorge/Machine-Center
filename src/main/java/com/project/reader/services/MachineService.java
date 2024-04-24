package com.project.reader.services;

import com.project.reader.exception.AppException;
import com.project.reader.model.MachineModel;
import com.project.reader.repository.MachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.Date;
import java.util.Optional;


@Service
public class MachineService extends AbstractService<MachineModel, MachineRepository> {


    @Autowired
    public MachineService(MachineRepository repository) {
        super(repository);
    }

    public MachineModel findBySerial(String serial){
        return repository.findBySerial(serial);
    }

    public MachineModel update(Long id, MachineModel machineModel, Principal principal) throws AppException {

        Date now = new Date();

        MachineModel machineVerify = findBySerial(machineModel.getSerial());

        machineVerify.setLastModifiedDate(now);

        return super.update(id, machineModel, machineVerify, principal);
    }

    @Override
    public MachineModel save(MachineModel machineModel) throws AppException {

        Optional<MachineModel> machineModelOpt = Optional.ofNullable(repository.findBySerial(machineModel.getSerial()));

        if (machineModelOpt.isPresent()) {
            throw new AppException("Machine with serial '" + machineModelOpt.get().getSerial() + "' already exists!", 422, null);
        }

        machineModel.setCreatedBy(1L);
        machineModel.setUpdatedBy(1L);

        return super.save(machineModel);
    }


}
