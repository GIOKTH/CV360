package com.ldblao.cv360.repositories;

import com.ldblao.cv360.entities.ManagesEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ManagesRepository extends CrudRepository<ManagesEntity, Long> {
    Optional<List<ManagesEntity>> findAllByMnEvaluatorAndAndMnStatus(String eval, String status) throws Exception;
}
