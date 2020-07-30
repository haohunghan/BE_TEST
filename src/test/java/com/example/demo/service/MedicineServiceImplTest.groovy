package com.example.demo.service

import com.example.demo.controller.request.MedicineGetRequest
import com.example.demo.controller.request.MedicinePostRequest
import com.example.demo.controller.response.MedicinePostResponse
import com.example.demo.domain.entity.MedicineEntity
import com.example.demo.domain.object.Medicine
import com.example.demo.infrastructure.ServiceStatus
import com.example.demo.repository.MedicineRepository
import com.example.demo.service.impl.MedicineServiceImpl
import spock.lang.Specification
import spock.lang.Unroll

class MedicineServiceImplTest extends Specification {

    MedicineRepository medicineRepository = Mock(MedicineRepository)
    MedicineServiceImpl medicineService = new MedicineServiceImpl(medicineRepository)

    @Unroll
    def "getRequest_normal"() {
        setup:
        MedicineGetRequest request = new MedicineGetRequest(id)
        medicineService.getMedicineById(request) >> new MedicineEntity()
        medicineService.getMedicineList(request) >> new ArrayList<>()

        when:
        def result = medicineService.getMedicines(request)

        then:
        result == expect

        where:
        id | expect
        "MD_00011" | Arrays.asList(new Medicine())
        null | new ArrayList<>()
    }

//    def "getRequest_getList"() {
//        setup:
//        MedicineGetRequest request = new MedicineGetRequest(null)
//        medicineService.getMedicineList() >> new ArrayList<>()
//        def medicines = medicineService.getMedicineList()
//        medicines.add(new MedicineEntity())
//        medicines.add(new MedicineEntity())
//
//        when:
//        def result = medicineService.getMedicines(request)
//        def expect = Arrays.asList(new Medicine(), new Medicine())
//
//        then:
//        result == expect
//    }

    def "getRequest_getMedicineListFail"() {
        setup:
        MedicineGetRequest request = new MedicineGetRequest(null)
        medicineRepository.findAll() >> new Medicine()

        when:
        def result = medicineService.getMedicineList(request)

        then:
        result == new ArrayList()
    }

    @Unroll
    def "postRequest_normalPost"() {
        setup:
        MedicinePostRequest medicinePostRequest = new MedicinePostRequest(id, name, price)

        def expect = new MedicinePostResponse(ServiceStatus.SUCCESS);

        when:
        def result = medicineService.postMedicine(medicinePostRequest)

        then:
        result == expect

        where:
        id          | name      | price
        // normal case: insert
        null        | "bruh"    | 1234556
        // update
        "MD_00001"  | "brahhhh" | 123545
        // insert but with id: still insert with id auto generator
        "MD_12001"  | "brahhhh" | 123545
    }

    def "postRequest_abnormalPost"() {
        setup:
        MedicinePostRequest medicinePostRequest = new MedicinePostRequest(id, name, price)

        def expect = new MedicinePostResponse(ServiceStatus.ERROR);

        when:
        def result = medicineService.postMedicine(medicinePostRequest)

        then:
        result == expect

        where:
        id          | name      | price
        // normal case: insert
        null        | null      | null
    }
}
