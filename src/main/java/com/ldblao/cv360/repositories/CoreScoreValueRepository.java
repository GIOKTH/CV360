package com.ldblao.cv360.repositories;

import com.ldblao.cv360.entities.SevenCoreValuesEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoreScoreValueRepository extends CrudRepository<SevenCoreValuesEntity, Long> {
}
