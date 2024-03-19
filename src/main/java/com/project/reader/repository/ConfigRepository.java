package com.project.reader.repository;

import com.project.reader.model.ConfigModel;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;

@Primary
public interface ConfigRepository extends JpaRepository<ConfigModel, Long>{


}
