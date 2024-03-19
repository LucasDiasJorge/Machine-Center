package com.project.reader.services;

import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.project.reader.exception.AppException;
import com.project.reader.model.AbstractModel;
import com.project.reader.util.AppBeansUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;


@SuppressWarnings("null")
public abstract class AbstractService<T extends AbstractModel, R extends JpaRepository<T,Long>> {

    @Autowired
    public R repository;


    @Autowired
    protected AbstractService(R repository) {
        this.repository = repository;
    }

    public List<T> findAll() throws AppException {
        try {
            return repository.findAll();
        } catch (Exception e) {
            throw new AppException("Error while GET entity", e.getCause(), 422, null);
        }
    }

    public T findById(Long id) throws AppException {
        return repository.findById(id)
                .orElseThrow(() -> new AppException("Id not found", 422, null));
    }

    public T save(T entity, Principal principal) throws AppException {
        try {
            entity.setLastModifiedDate(new Date());
            entity.setDeletedAt(new Date(0));
            entity.setCreatedAt(new Date());
            return repository.save(entity);
        } catch (Exception e) {
            throw new AppException("Error while creating new " + entity.getClass().getSimpleName(), e.getCause(), 422,
                    null);
        }

    }

    public T save(T entity) throws AppException {
        try {
            entity.setLastModifiedDate(new Date());
            entity.setDeletedAt(new Date(0));
            entity.setCreatedAt(new Date());
            return repository.save(entity);
        } catch (Exception e) {
            throw new AppException("Error while creating new " + entity.getClass().getSimpleName(), e.getCause(), 422,
                    null);
        }

    }

    public T update(Long id, T entity, T existingEntity, Principal principal) throws AppException {
        try {
            AppBeansUtil.copyProperties(entity, existingEntity,
                    AppBeansUtil.getNullPropertyNames(entity, "id", "company"));
            existingEntity.setLastModifiedDate(new Date());
            return repository.save(existingEntity);
        } catch (Exception e) {
            throw new AppException("Error while updating new " + entity.getClass().getSimpleName(), e.getCause(), 422,
                    null);
        }

    }

    public T update(Long id, T entity) {
        return repository.save(entity);
    }

    public void updatedAll(List<T> entities) {
        List<Long> entityIds = entities.stream().map(e -> e.getId()).collect(Collectors.toList());

        List<T> existingEntities = repository.findAllById(entityIds);

        for (T e : entities) {
            T findEntity = existingEntities.stream()
                    .filter(existingEntity -> existingEntity.getId().equals(e.getId()))
                    .findFirst()
                    .orElse(null);

            if (findEntity != null) {
                AppBeansUtil.copyProperties(e, findEntity, AppBeansUtil.getNullPropertyNames(e, "id"));
            }
        }

        updateInBatches(existingEntities);
    }

    public T delete(Long id, T entity, Principal principal) throws AppException {
        try {
            entity.setDeletedAt(new Date());
            return repository.save(entity);
        } catch (Exception e) {
            throw new AppException("Error while deleting " + entity.getClass().getSimpleName(), e.getCause(), 422,
                    null);
        }
    }

    public void updateInBatches(List<T> entities) {
        int batchSize = 100000000; 
        for (int i = 0; i < entities.size(); i += batchSize) {
            int toIndex = Math.min(i + batchSize, entities.size());
            repository.saveAll(entities.subList(i, toIndex));
        }
    }

    public void saveInBatches(List<T> entities) {
        int batchSize = 10000000;
        for (int i = 0; i < entities.size(); i += batchSize) {
            int toIndex = Math.min(i + batchSize, entities.size());
            if (toIndex > i) {
                repository.saveAll(entities.subList(i, toIndex));
            }
        }
    }
}