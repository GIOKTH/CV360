package com.ldblao.cv360.repositories;

import com.ldblao.cv360.entities.ThirteenIndicatorsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndicatorRepository extends CrudRepository<ThirteenIndicatorsEntity, Long> {
}
