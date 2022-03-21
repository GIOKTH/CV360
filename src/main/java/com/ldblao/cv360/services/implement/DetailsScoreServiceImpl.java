package com.ldblao.cv360.services.implement;

import com.ldblao.cv360.components.ResponseHelper;
import com.ldblao.cv360.entities.DetailsScoresEntity;
import com.ldblao.cv360.entities.ThirteenIndicatorsEntity;
import com.ldblao.cv360.messages.request.DetailsRequest;
import com.ldblao.cv360.repositories.DetailScoreRepository;
import com.ldblao.cv360.services.DetailScoreService;
import com.ldblao.cv360.utils.ObjectMapperUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;

@Service
@Slf4j
public class DetailsScoreServiceImpl implements DetailScoreService {
    private final ResponseHelper responseHelper;
    private final DetailScoreRepository detailScoreRepository;

    public DetailsScoreServiceImpl(ResponseHelper responseHelper, DetailScoreRepository detailScoreRepository) {
        this.responseHelper = responseHelper;
        this.detailScoreRepository = detailScoreRepository;
    }

    @Override
    public HashMap<String, Object> AllDetails() throws Exception {
        try {
            Iterable<DetailsScoresEntity> detailsScoresEntities = this.detailScoreRepository.findAll();
            return this.responseHelper.success(detailsScoresEntities, "success");
        } catch (Exception exception) {
            return this.responseHelper.failed(null, "ຜິດພາດ, ບໍ່ສາມາດເອີ້ນຂໍ້ມູນທັງໝົດໄດ້!");
        }
    }

    @Override
    public HashMap<String, Object> GetDetailById(Long id) throws Exception {
        Optional<DetailsScoresEntity> detailsScoresEntities = this.detailScoreRepository.findById(id);
        if (detailsScoresEntities.isPresent()) {
            try {
                return this.responseHelper.success(detailsScoresEntities.get(), "success");
            } catch (Exception exception) {
                return this.responseHelper.failed(null, "ຜິດພາດ, ບໍ່ສາມາດເອີ້ນຂໍ້ມູນທັງໝົດໄດ້!");
            }
        }
        return this.responseHelper.failed(null, "ບໍ່ພົບຂໍ້ມູນໃດໆໃນລະບົບ, ກາລຸນາລອງໃໝ່ໃນພາຍຫຼັງ!");
    }

    @Override
    public HashMap<String, Object> NewDetail(DetailsRequest detailsRequest) throws Exception {
        DetailsScoresEntity detailsScoresEntity = ObjectMapperUtils.map(detailsRequest, DetailsScoresEntity.class);
        try {
            this.detailScoreRepository.save(detailsScoresEntity);
            return this.responseHelper.success(null, "ສຳເລັດ, ການສ້າງຂໍ້ມູນໃໝ່ສຳເລັດ!");
        } catch (Exception exception) {
            return this.responseHelper.failed(null, "ຜິດພາດ, ບໍ່ສາມາດເພີ່ມຂໍ້ມູນໄດ້!");
        }
    }

    @Override
    public HashMap<String, Object> UpdateDetail(Long id, DetailsRequest detailsRequest) throws Exception {
        Optional<DetailsScoresEntity> detailsScoresEntity = this.detailScoreRepository.findById(id);
        if (detailsScoresEntity.isPresent()) {
            detailsScoresEntity.get().setDsNo(detailsRequest.getDsNo());
            detailsScoresEntity.get().setDsScore(detailsRequest.getDsScore());
            detailsScoresEntity.get().setDsNameEn(detailsRequest.getDsNameEn());
            detailsScoresEntity.get().setDsNameLa(detailsRequest.getDsNameLa());
            try {
                this.detailScoreRepository.save(detailsScoresEntity.get());
                return this.responseHelper.success(null, "ສຳເລັດ, ການອັບເດດຂໍ້ມູນສຳເລັດແລ້ວເດີ!");
            } catch (Exception exception) {
                return this.responseHelper.failed(null, "ຜິດພາດ, ບໍ່ພົບຂໍ້ມູນທີ່ທ່ານຕ້ອງການອັບເດດ!");
            }
        }
        return this.responseHelper.failed(null, "ຜິດພາດ, ບໍ່ພົບຂໍ້ມູນທີ່ທ່ານຕ້ອງການອັບເດດ!");
    }

    @Override
    public HashMap<String, Object> DeleteDetail(Long id) throws Exception {
        Optional<DetailsScoresEntity> detailsScoresEntity = this.detailScoreRepository.findById(id);
        if (detailsScoresEntity.isPresent()) {
            try {
                this.detailScoreRepository.delete(detailsScoresEntity.get());
                return this.responseHelper.success(null, "ສຳເລັດ, ການລຶບຂໍ້ມູນສຳເລັດ!");
            } catch (Exception exception) {
                return this.responseHelper.failed(null, "ຜິດພາດ, ບໍ່ສາມາດລຶບຂໍ້ມູນທີ່ຕ້ອງການໄດ້!");
            }
        }
        return this.responseHelper.failed(null, "ວ່າງເປົ່າ, ບໍ່ສາມາດລຶບຂໍ້ມູນທີ່ຕ້ອງການໄດ້!");
    }
}
