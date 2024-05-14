package com.project.reader.repository;

import com.project.reader.model.MachineModel;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Primary
public interface MachineRepository extends JpaRepository<MachineModel, Long> {

    @Query("SELECT m FROM MachineModel m WHERE m.deletedBy IS NULL AND m.serial = :serial")
    MachineModel findBySerial(@Param("serial") String serial);

    @Query("SELECT m FROM MachineModel m WHERE m.deletedBy IS NULL AND m.companyId = :companyId")
    List<MachineModel> findByCompanyId(@Param("companyId") Long companyId);

}
