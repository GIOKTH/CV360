package com.ldblao.cv360.services.implement;

import com.ldblao.cv360.components.ResponseHelper;
import com.ldblao.cv360.entities.ManagesEntity;
import com.ldblao.cv360.messages.request.ManagesRequest;
import com.ldblao.cv360.messages.request.MultiManage;
import com.ldblao.cv360.repositories.ManagesRepository;
import com.ldblao.cv360.services.ManagesService;
import com.ldblao.cv360.utils.ObjectMapperUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ManagesServiceImpl implements ManagesService {
    private final ResponseHelper responseHelper;
    private final ManagesRepository managesRepository;

    public ManagesServiceImpl(
            ResponseHelper responseHelper,
            ManagesRepository managesRepository) {
        this.responseHelper = responseHelper;
        this.managesRepository = managesRepository;
    }

    @Override
    public HashMap<String, Object> AllManages() throws Exception {
        try {
            Iterable<ManagesEntity> managesEntities = this.managesRepository.findAll();
            return this.responseHelper.success(managesEntities, "success");
        } catch (Exception exception) {
            return this.responseHelper.failed(null, "ຜິດພາດ, ບໍສາມາດເອີ້ນຂໍ້ມູນໄດ້");
        }
    }

    @Override
    public HashMap<String, Object> CreateNewManages(ManagesRequest managesRequest) throws Exception {
        ManagesEntity sendmanagesRequest = ObjectMapperUtils.map(managesRequest, ManagesEntity.class);
        try {
            this.managesRepository.save(sendmanagesRequest);
            return this.responseHelper.success(null, "ເພີ່ມຂໍ້ມູນໃຫມ່ສຳເລັດ!");
        } catch (Exception exception) {
            return this.responseHelper.failed(null, "ຜິດພາດ, ບໍ່ສາມາດເພີ່ມຂໍ້ມູນໄດ້!");
        }
    }

    @Override
    public HashMap<String, Object> CreateNewManagesV2(MultiManage multiManage) throws Exception {
        ManagesEntity sendmanagesRequest = ObjectMapperUtils.map(multiManage, ManagesEntity.class);
        try {
            ManagesEntity manage = new ManagesEntity();
            manage.setMnEvaluator(multiManage.getMnEvaluatedPerson());
            manage.setMnEvaluatedPerson(multiManage.getMnEvaluatedPerson());
            manage.setMnStatus(multiManage.getMnStatus());
            manage.setMnDate(multiManage.getMnDate());
            this.managesRepository.save(manage);
            multiManage.getMnEvaluator().forEach(item ->{
                ManagesEntity manages = new ManagesEntity();
                manages.setMnEvaluator(item.getEvaluator());
                manages.setMnEvaluatedPerson(multiManage.getMnEvaluatedPerson());
                manages.setMnStatus(multiManage.getMnStatus());
                manages.setMnDate(multiManage.getMnDate());
                this.managesRepository.save(manages);
            });
            this.managesRepository.save(sendmanagesRequest);
            return this.responseHelper.success(null, "ເພີ່ມຂໍ້ມູນໃຫມ່ສຳເລັດ!");
        } catch (Exception exception) {
            return this.responseHelper.failed(null, "ຜິດພາດ, ບໍ່ສາມາດເພີ່ມຂໍ້ມູນໄດ້!");
        }
    }

    @Override
    public HashMap<String, Object> ByIdManages(Long id) throws Exception {
        try {
            Optional<ManagesEntity> managesEntities = this.managesRepository.findById(id);
            if (managesEntities.isPresent()) {
                return this.responseHelper.success(managesEntities.get(), "success");
            }
            return this.responseHelper.failed(null, "ບໍ່ພົບຂໍ້ມູນ");
        } catch (Exception exception) {
            return this.responseHelper.failed(null, "ຜິດພາດ, ບໍ່ສາມາດເອີ້ນຂໍ້ມູນໄດ້");
        }
    }

    @Override
    public HashMap<String, Object> ByEvalByStatusManages(String eval, String status) throws Exception {
        try {
            Optional<List<ManagesEntity>> managesEntities =
                    this.managesRepository.findAllByMnEvaluatorAndAndMnStatus(eval, status);
            if (managesEntities.isPresent()) {
                return this.responseHelper.success(managesEntities.get(), "success");
            }
            return this.responseHelper.failed(null, "ບໍພົບຂໍ້ມູນ");
        } catch (Exception exception) {
            return this.responseHelper.failed(null, "ຜິດພາດ, ບໍ່ສາມາດເອີ້ນຂໍ້ມູນໄດ້");
        }
    }

//    @Override
//    public HashMap<String, Object> ByEvalManages(String eval, String status) throws Exception {
//        try {
//            Optional<List<ManagesEntity>> managesEntity =
//                    this.managesRepository.findAllByMnEvaluatorAndAndMnStatus(eval, status);
//            if (managesEntity.isPresent()) {
//                return this.responseHelper.success(managesEntity.get(), "success");
//            }
//            return this.responseHelper.failed(null, "ບໍພົບຂໍ້ມູນ");
//        } catch (Exception exception) {
//            return this.responseHelper.failed(null, "ຜິດພາດ, ບໍ່ສາມາດເອີ້ນຂໍ້ມູນໄດ້");
//        }
//    }

    @Override
    public HashMap<String, Object> UpdateManages(Long id, ManagesRequest managesRequest) throws Exception {
        Optional<ManagesEntity> managesEntity = this.managesRepository.findById(id);
        if (managesEntity.isPresent()) {
            managesEntity.get().setMnEvaluator(managesRequest.getMnEvaluator());
            managesEntity.get().setMnEvaluatedPerson(managesRequest.getMnEvaluatedPerson());
            managesEntity.get().setMnStatus(managesRequest.getMnStatus());
            try {
                this.managesRepository.save(managesEntity.get());
                return this.responseHelper.success(null, "ສຳເລັດ, ການສ້າງຂໍ້ມູນໃຫມ່ສຳເລັດ!");
            } catch (Exception exception) {
                return this.responseHelper.failed(null, "ຜິດພາດ, ບໍ່ສາມາດເພີ່ມຂໍ້ມູນໄດ້");
            }
        }
        return this.responseHelper.failed(null, "ຜິດພາດ, ບໍ່ພົບຂໍ້ມູນທີ່ທ່ານຕ້ອງການອັບເດດ!");
    }

    @Override
    public HashMap<String, Object> DeleteManages(Long id) throws Exception {
        Optional<ManagesEntity> managesEntity = this.managesRepository.findById(id);
        if (!managesEntity.isPresent()) {
            return this.responseHelper.failed(null, "ຂໍ້ມູນຖືກລົບແລ້ວ!");
        }
        try {
            this.managesRepository.delete(managesEntity.get());
            return this.responseHelper.success(null, "ລົບຂໍ້ມູນສຳເລັດ!");
        } catch (Exception exception) {
            return this.responseHelper.failed(null, "ຜິດພາດ, ບໍ່ສາມາດລຶບຂໍ້ມູນທີ່ຕ້ອງການໄດ້!");
        }
    }

}
