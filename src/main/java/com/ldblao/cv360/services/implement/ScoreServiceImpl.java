package com.ldblao.cv360.services.implement;

import com.ldblao.cv360.components.ResponseHelper;
import com.ldblao.cv360.entities.DetailsScoresEntity;
import com.ldblao.cv360.entities.ManagesEntity;
import com.ldblao.cv360.entities.ScoresEntity;
import com.ldblao.cv360.entities.ThirteenIndicatorsEntity;
import com.ldblao.cv360.messages.request.ScoreRequest;
import com.ldblao.cv360.repositories.*;
import com.ldblao.cv360.services.ScoreService;
import com.ldblao.cv360.utils.ObjectMapperUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
public class ScoreServiceImpl implements ScoreService {
    private final ResponseHelper responseHelper;
    private final ScoreRepository scoreRepository;
    private final ManagesRepository managesRepository;
    private final IndicatorRepository indicatorRepository;
    private final DetailScoreRepository detailScoreRepository;
    private final JdbcTemplate jdbcTemplate;

    public ScoreServiceImpl(ResponseHelper responseHelper, ScoreRepository scoreRepository, ManagesRepository managesRepository, IndicatorRepository indicatorRepository, DetailScoreRepository detailScoreRepository, JdbcTemplate jdbcTemplate) {
        this.responseHelper = responseHelper;
        this.scoreRepository = scoreRepository;
        this.managesRepository = managesRepository;
        this.indicatorRepository = indicatorRepository;
        this.detailScoreRepository = detailScoreRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public HashMap<String, Object> AllScoreValues() throws Exception {
        try {

            Iterable<ScoresEntity> scoresEntities = this.scoreRepository.findAll();
            System.out.println(scoresEntities);
            return this.responseHelper.success(scoresEntities, "success");

        } catch (Exception exception) {
            return this.responseHelper.failed(null, "ຜິດພາດ, ບໍ່ສາມາດເອີ້ນຂໍ້ມູນທັງໝົດໄດ້!");
        }
    }

    @Override
    public HashMap<String, Object> GetScoreValueById(Long id) throws Exception {
        Optional<ScoresEntity> scoresEntities = this.scoreRepository.findById(id);
        if (scoresEntities.isPresent()) {
            try {
                return this.responseHelper.success(scoresEntities.get(), "success");
            } catch (Exception exception) {
                return this.responseHelper.failed(null, "ຜິດພາດ, ບໍ່ສາມາດເອີ້ນຂໍ້ມູນທັງໝົດໄດ້!");
            }
        }
        return this.responseHelper.failed(null, "ບໍ່ພົບຂໍ້ມູນໃດໆໃນລະບົບ, ກາລຸນາລອງໃໝ່ໃນພາຍຫຼັງ!");
    }

    @Override
    public HashMap<String, Object> NewScore(ScoreRequest scoreRequest) throws Exception {
        ScoresEntity scoresEntity = ObjectMapperUtils.map(scoreRequest, ScoresEntity.class);
        Optional<ThirteenIndicatorsEntity> thirteenIndicators = this.indicatorRepository.findById(scoreRequest.getScThvId());
        Optional<DetailsScoresEntity> detailsScores = this.detailScoreRepository.findById(scoreRequest.getScDetailsScoreId());
        Optional<ManagesEntity> manages = this.managesRepository.findById(scoreRequest.getScMnId());
        try {
            scoresEntity.setDetailsScores(detailsScores.get());
            scoresEntity.setManages(manages.get());
            scoresEntity.setThirteenIndicators(thirteenIndicators.get());
            this.scoreRepository.save(scoresEntity);
            return this.responseHelper.success(null, "ສຳເລັດ, ການສ້າງຂໍ້ມູນໃໝ່ສຳເລັດ!");
        } catch (Exception exception) {
            return this.responseHelper.failed(null, "ຜິດພາດ, ບໍ່ສາມາດເພີ່ມຂໍ້ມູນໄດ້!");
        }
    }

    @Override
    public HashMap<String, Object> MultiNewScore(List<ScoreRequest> scoreRequests) throws Exception {

        try {
            for (int i = 0; i < scoreRequests.size(); i++) {
                ScoresEntity scoresEntity = ObjectMapperUtils.map(scoreRequests.get(i), ScoresEntity.class);
                this.scoreRepository.save(scoresEntity);
            }
            return this.responseHelper.success(null, "ສຳເລັດ, ການສ້າງຂໍ້ມູນໃໝ່ສຳເລັດ!");
        } catch (Exception exception) {
            return this.responseHelper.failed(null, "ຜິດພາດ, ບໍ່ສາມາດເພີ່ມຂໍ້ມູນໄດ້!");
        }

    }

    @Override
    public HashMap<String, Object> UpdateScore(Long id, ScoreRequest scoreRequest) throws Exception {
        Optional<ScoresEntity> scoresEntity = this.scoreRepository.findById(id);
        Optional<ThirteenIndicatorsEntity> thirteenIndicators = this.indicatorRepository.findById(scoreRequest.getScThvId());
        Optional<DetailsScoresEntity> detailsScores = this.detailScoreRepository.findById(scoreRequest.getScDetailsScoreId());
        Optional<ManagesEntity> manages = this.managesRepository.findById(scoreRequest.getScMnId());
        if (scoresEntity.isPresent()) {
            scoresEntity.get().setThirteenIndicators(thirteenIndicators.get());
            scoresEntity.get().setDetailsScores(detailsScores.get());
            scoresEntity.get().setManages(manages.get());
            scoresEntity.get().setScDate(scoreRequest.getScDate());
            scoresEntity.get().setScRemarkStrength(scoreRequest.getScRemarkStrength());
            scoresEntity.get().setScRemarkWeakness(scoreRequest.getScRemarkWeakness());
            scoresEntity.get().setScRemarkSolutions(scoreRequest.getScRemarkSolutions());
            scoresEntity.get().setScOwnWork(scoreRequest.getScOwnWork());
            try {
                this.scoreRepository.save(scoresEntity.get());
                return this.responseHelper.success(null, "ສຳເລັດ, ການອັບເດດຂໍ້ມູນສຳເລັດແລ້ວເດີ!");
            } catch (Exception exception) {
                return this.responseHelper.failed(null, "ຜິດພາດ, ບໍ່ພົບຂໍ້ມູນທີ່ທ່ານຕ້ອງການອັບເດດ!");
            }
        }
        return this.responseHelper.failed(null, "ຜິດພາດ, ບໍ່ພົບຂໍ້ມູນທີ່ທ່ານຕ້ອງການອັບເດດ!");
    }

    @Override
    public HashMap<String, Object> DeleteScore(Long id) throws Exception {
        Optional<ScoresEntity> scoresEntity = this.scoreRepository.findById(id);
        if (scoresEntity.isPresent()) {
            try {
                this.scoreRepository.delete(scoresEntity.get());
                return this.responseHelper.success(null, "ສຳເລັດ, ການລຶບຂໍ້ມູນສຳເລັດ!");
            } catch (Exception exception) {
                return this.responseHelper.failed(null, "ຜິດພາດ, ບໍ່ສາມາດລຶບຂໍ້ມູນທີ່ຕ້ອງການໄດ້!");
            }
        }
        return this.responseHelper.failed(null, "ວ່າງເປົ່າ, ບໍ່ສາມາດລຶບຂໍ້ມູນທີ່ຕ້ອງການໄດ້!");
    }

    @Override
    public HashMap<String, Object> JoinScoreToManage() throws Exception {

        List<Map<String, Object>> response = this.jdbcTemplate.queryForList("select * from scores T1 LEFT JOIN" +
                " manages T2 on T1.sc_mn_id = T2.mn_id");
        return this.responseHelper.success(response, "success");
    }
}
