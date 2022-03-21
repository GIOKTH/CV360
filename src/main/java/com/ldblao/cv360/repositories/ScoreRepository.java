package com.ldblao.cv360.repositories;

import com.ldblao.cv360.entities.ScoresEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreRepository extends CrudRepository<ScoresEntity, Long> {
}
