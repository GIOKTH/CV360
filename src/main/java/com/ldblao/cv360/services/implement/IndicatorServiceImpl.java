package com.ldblao.cv360.services.implement;

import com.ldblao.cv360.components.ResponseHelper;
import com.ldblao.cv360.entities.SevenCoreValuesEntity;
import com.ldblao.cv360.entities.ThirteenIndicatorsEntity;
import com.ldblao.cv360.messages.request.IndicatorRequest;
import com.ldblao.cv360.repositories.CoreScoreValueRepository;
import com.ldblao.cv360.repositories.IndicatorRepository;
import com.ldblao.cv360.services.IndicatorService;
import com.ldblao.cv360.utils.ObjectMapperUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;

@Service
@Slf4j
public class IndicatorServiceImpl implements IndicatorService {
    private final IndicatorRepository indicatorRepository;
    private final CoreScoreValueRepository coreScoreValueRepository;
    private final ResponseHelper responseHelper;

    public IndicatorServiceImpl(IndicatorRepository indicatorRepository, CoreScoreValueRepository coreScoreValueRepository, ResponseHelper responseHelper) {
        this.indicatorRepository = indicatorRepository;
        this.coreScoreValueRepository = coreScoreValueRepository;
        this.responseHelper = responseHelper;
    }

    @Override
    public HashMap<String, Object> AllIndicator() throws Exception {
        try {
            Iterable<ThirteenIndicatorsEntity> scoresEntities = this.indicatorRepository.findAll();
            return this.responseHelper.success(scoresEntities, "success");
        } catch (Exception exception) {
            return this.responseHelper.failed(null, "ຜິດພາດ, ບໍ່ສາມາດເອີ້ນຂໍ້ມູນທັງໝົດໄດ້!");
        }
    }

    @Override
    public HashMap<String, Object> GetIndicatorById(Long id) throws Exception {
        Optional<ThirteenIndicatorsEntity> scoresEntities = this.indicatorRepository.findById(id);
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
    public HashMap<String, Object> NewIndicator(IndicatorRequest indicatorRequest) throws Exception {
        ThirteenIndicatorsEntity scoresEntity = ObjectMapperUtils.map(indicatorRequest, ThirteenIndicatorsEntity.class);
        Optional<SevenCoreValuesEntity> sevenCoreValues = this.coreScoreValueRepository.findById(indicatorRequest.getThvScvId());
        try {
            scoresEntity.setSevenCoreValues(sevenCoreValues.get());
            this.indicatorRepository.save(scoresEntity);
            return this.responseHelper.success(null, "ສຳເລັດ, ການສ້າງຂໍ້ມູນໃໝ່ສຳເລັດ!");
        } catch (Exception exception) {
            return this.responseHelper.failed(null, "ຜິດພາດ, ບໍ່ສາມາດເພີ່ມຂໍ້ມູນໄດ້!");
        }
    }

    @Override
    public HashMap<String, Object> UpdateIndicator(Long id, IndicatorRequest indicatorRequest) throws Exception {
        Optional<ThirteenIndicatorsEntity> indicatorsEntity = this.indicatorRepository.findById(id);
        Optional<SevenCoreValuesEntity> sevenCoreValues = this.coreScoreValueRepository.findById(indicatorRequest.getThvScvId());
        if (indicatorsEntity.isPresent()) {
            indicatorsEntity.get().setThvNameLa(indicatorRequest.getThvNameLa());
            indicatorsEntity.get().setThvNameEn(indicatorRequest.getThvNameEn());
            indicatorsEntity.get().setSevenCoreValues(sevenCoreValues.get());
            indicatorsEntity.get().setScvNameEn(indicatorRequest.getScvNameEn());
            indicatorsEntity.get().setScvNameLa(indicatorRequest.getScvNameLa());
            try {
                this.indicatorRepository.save(indicatorsEntity.get());
                return this.responseHelper.success(null, "ສຳເລັດ, ການອັບເດດຂໍ້ມູນສຳເລັດແລ້ວເດີ!");
            } catch (Exception exception) {
                return this.responseHelper.failed(null, "ຜິດພາດ, ບໍ່ພົບຂໍ້ມູນທີ່ທ່ານຕ້ອງການອັບເດດ!");
            }
        }
        return this.responseHelper.failed(null, "ຜິດພາດ, ບໍ່ພົບຂໍ້ມູນທີ່ທ່ານຕ້ອງການອັບເດດ!");
    }

    @Override
    public HashMap<String, Object> DeleteIndicator(Long id) throws Exception {
        Optional<ThirteenIndicatorsEntity> thirteenIndicatorsEntity = this.indicatorRepository.findById(id);
        if (thirteenIndicatorsEntity.isPresent()) {
            try {
                this.indicatorRepository.delete(thirteenIndicatorsEntity.get());
                return this.responseHelper.success(null, "ສຳເລັດ, ການລຶບຂໍ້ມູນສຳເລັດ!");
            } catch (Exception exception) {
                return this.responseHelper.failed(null, "ຜິດພາດ, ບໍ່ສາມາດລຶບຂໍ້ມູນທີ່ຕ້ອງການໄດ້!");
            }
        }
        return this.responseHelper.failed(null, "ວ່າງເປົ່າ, ບໍ່ສາມາດລຶບຂໍ້ມູນທີ່ຕ້ອງການໄດ້!");
    }
}
