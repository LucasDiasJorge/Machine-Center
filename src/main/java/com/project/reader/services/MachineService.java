package com.project.reader.services;

import com.project.reader.model.MachineModel;
import com.project.reader.repository.MachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class MachineService extends AbstractService<MachineModel, MachineRepository> {


    @Autowired
    public MachineService(MachineRepository repository) {
        super(repository);
    }

}
