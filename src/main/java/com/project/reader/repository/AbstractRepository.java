package com.project.reader.repository;

import com.project.reader.model.AbstractModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbstractRepository extends JpaRepository<AbstractModel, Long> {

}
