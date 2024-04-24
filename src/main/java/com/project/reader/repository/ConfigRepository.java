package com.project.reader.repository;

import com.project.reader.model.ConfigModel;
import com.project.reader.model.MachineModel;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Primary
public interface ConfigRepository extends JpaRepository<ConfigModel, Long>{


    @Query("SELECT c FROM ConfigModel c WHERE c.deletedBy IS NULL AND c.machineModel.id = :machineId")
    ConfigModel findByMachine(@Param("machineId") Long machineId);

}
