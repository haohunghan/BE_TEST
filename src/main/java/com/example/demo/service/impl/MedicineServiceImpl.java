package com.example.demo.service.impl;

import com.example.demo.controller.request.MedicineGetRequest;
import com.example.demo.controller.request.MedicinePostRequest;
import com.example.demo.controller.response.MedicinePostResponse;
import com.example.demo.domain.entity.MedicineEntity;
import com.example.demo.domain.object.Medicine;
import com.example.demo.infrastructure.ServiceStatus;
import com.example.demo.repository.MedicineRepository;
import com.example.demo.service.MedicineService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class MedicineServiceImpl implements MedicineService {

    private final MedicineRepository medicineRepository;

    /**
     * method get all medicine
     * @return
     */
    @Override
    public List<Medicine> getMedicines(MedicineGetRequest request) throws Exception {

        // true: get list
        // false: get 1
        boolean isGetList = StringUtils.isEmpty(request.getId());

        List<Medicine> response = new ArrayList<>();

        List<MedicineEntity> medicineEntityList;

        // get list medicine
        if (isGetList) {
            try {
                medicineEntityList = medicineRepository.findAll();
            } catch (Exception e) {
                return response;
            }

            // if get empty/null list
            if (CollectionUtils.isEmpty(medicineEntityList)) {
                return response;
            }

            medicineEntityList.forEach(medicineEntity -> {
                Medicine medicine = mappingMedicine(medicineEntity);
                response.add(medicine);
            });

            // get 1 medicine
        } else {
            MedicineEntity medicineEntity = this.getMedicineById(request);
            if ( medicineEntity == null) {
                return response;
            } else {
                Medicine medicine = mappingMedicine(medicineEntity);
                response.add(medicine);
            }
        }

        return response;
    }

    /**
     * get 1 medicine by id
     * @param request id
     * @return medicine
     * @throws Exception
     */
    @Override
    public MedicineEntity getMedicineById(MedicineGetRequest request) throws Exception {
        return medicineRepository.findById(request.getId()).orElseThrow(Exception::new);
    }

    /**
     * register/update medicine
     * @param request MedicineRequest
     * @return
     */
    @Override
    public MedicinePostResponse postMedicine(MedicinePostRequest request) {
        MedicineEntity medicineEntity = MedicineEntity.builder()
                .id(request.getId())
                .name(request.getName())
                .price(request.getPrice())
                .build();
        try {
            medicineRepository.save(medicineEntity);
            return MedicinePostResponse.builder()
                    .status(ServiceStatus.SUCCESS)
                    .build();
        } catch (Exception e) {
            return MedicinePostResponse.builder().status(ServiceStatus.ERROR).build();
        }
    }

    public Medicine mappingMedicine (MedicineEntity medicineEntity) {
        return Medicine.builder()
                .id(medicineEntity.getId())
                .name(medicineEntity.getName())
                .price(medicineEntity.getPrice())
                .build();
    }
}
