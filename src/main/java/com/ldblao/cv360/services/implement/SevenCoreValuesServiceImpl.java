package com.ldblao.cv360.services.implement;

import com.ldblao.cv360.components.ResponseHelper;
import com.ldblao.cv360.entities.SevenCoreValuesEntity;
import com.ldblao.cv360.messages.request.SevenCoreScoreValueRequest;
import com.ldblao.cv360.repositories.CoreScoreValueRepository;
import com.ldblao.cv360.services.SevencoreValueService;
import com.ldblao.cv360.utils.ObjectMapperUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;

@Service
@Slf4j
public class SevenCoreValuesServiceImpl implements SevencoreValueService {
    private final ResponseHelper responseHelper;
    private final CoreScoreValueRepository coreScoreValueRepository;

    public SevenCoreValuesServiceImpl(
             ResponseHelper responseHelper,
             CoreScoreValueRepository coreScoreValueRepository) {
        this.responseHelper = responseHelper;
        this.coreScoreValueRepository = coreScoreValueRepository;
    }

    @Override
    public HashMap<String, Object> AllCoreScoreValues() throws Exception {
        try {
            Iterable<SevenCoreValuesEntity> coreValuesEntities = this.coreScoreValueRepository.findAll();
            /*if (coreValuesEntities.spliterator().getExactSizeIfKnown() > 0) {
                return this.responseHelper.failed(null, "ບໍ່ພົບຂໍ້ມູນ, ບໍ່ສາມາດເອີ້ນຂໍ້ມູນທັງໝົດໄດ້");
            }*/
            return this.responseHelper.success(coreValuesEntities, "success");
        } catch (Exception exception) {
            return this.responseHelper.failed(null, "ຜິດພາດ, ບໍ່ສາມາດເອີ້ນຂໍ້ມູນທັງໝົດໄດ້");
        }
    }

    @Override
    public HashMap<String, Object> GetCoreScoreValueById(Long id) throws Exception {
        try {
            Optional<SevenCoreValuesEntity> coreValuesEntities = this.coreScoreValueRepository.findById(id);
            if (coreValuesEntities.isPresent()) {
                return this.responseHelper.success(coreValuesEntities.get(), "success");
            }
            return this.responseHelper.failed(null, "ບໍ່ພົບຂໍ້ມູນ, ບໍ່ສາມາດເອີ້ນຂໍ້ມູນທັງໝົດໄດ້");
        } catch (Exception exception) {
            return this.responseHelper.failed(null, "ຜິດພາດ, ບໍ່ສາມາດເອີ້ນຂໍ້ມູນທັງໝົດໄດ້");
        }
    }

    @Override
    public HashMap<String, Object> NewCoreScore(SevenCoreScoreValueRequest sevenCoreScoreValueRequest) throws Exception {
        SevenCoreValuesEntity scoreValueRequest = ObjectMapperUtils.map(sevenCoreScoreValueRequest, SevenCoreValuesEntity.class);
        try{
            this.coreScoreValueRepository.save(scoreValueRequest);
            return this.responseHelper.success(null,"ສຳເລັດ, ການສ້າງຂໍ້ມູນໃໝ່ສຳເລັດ!");
        }catch (Exception exception){
            return this.responseHelper.failed(null, "ຜິດພາດ, ບໍ່ສາມາດເພີ່ມຂໍ້ມູນໄດ້!");
        }
    }

    @Override
    public HashMap<String, Object> UpdateCoreScore(Long id, SevenCoreScoreValueRequest sevenCoreScoreValueRequest) throws Exception {
        Optional<SevenCoreValuesEntity> sevenCoreValuesEntity = this.coreScoreValueRepository.findById(id);
        if (sevenCoreValuesEntity.isPresent()){
            sevenCoreValuesEntity.get().setScvNameEn(sevenCoreScoreValueRequest.getScvNameEn());
            sevenCoreValuesEntity.get().setScvNameLa(sevenCoreScoreValueRequest.getScvNameLa());
            try{
                this.coreScoreValueRepository.save(sevenCoreValuesEntity.get());
                return this.responseHelper.success(null,"ສຳເລັດ, ການອັບເດດຂໍ້ມູນສຳເລັດແລ້ວເດີ!");
            }catch (Exception exception){
                return this.responseHelper.failed(null, "ຜິດພາດ, ບໍ່ສາມາດເພີ່ມຂໍ້ມູນໄດ້!");
            }
        }
        return this.responseHelper.failed(null,"ຜິດພາດ, ບໍ່ພົບຂໍ້ມູນທີ່ທ່ານຕ້ອງການອັບເດດ!");
    }

    @Override
    public HashMap<String, Object> DeleteCoreScore(Long id) throws Exception {
        Optional<SevenCoreValuesEntity> sevenCoreValuesEntity = this.coreScoreValueRepository.findById(id);
        if (!sevenCoreValuesEntity.isPresent()){
            return this.responseHelper.failed(null, "ວ່າງເປົ່າ, ບໍ່ສາມາດລຶບຂໍ້ມູນທີ່ຕ້ອງການໄດ້!");
        }
        try{
            this.coreScoreValueRepository.delete(sevenCoreValuesEntity.get());
            return this.responseHelper.success(null,"ສຳເລັດ, ການລຶບຂໍ້ມູນສຳເລັດ!");
        }catch (Exception exception){
            return this.responseHelper.failed(null,"ຜິດພາດ, ບໍ່ສາມາດລຶບຂໍ້ມູນທີ່ຕ້ອງການໄດ້!");
        }
    }
}
