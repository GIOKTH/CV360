package com.ldblao.cv360.repositories;

import com.ldblao.cv360.entities.DetailsScoresEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailScoreRepository extends CrudRepository<DetailsScoresEntity, Long> {
}
