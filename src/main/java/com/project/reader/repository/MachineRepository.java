package com.project.reader.repository;

import com.project.reader.model.MachineModel;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;

@Primary
public interface MachineRepository extends JpaRepository<MachineModel, Long> {

}
