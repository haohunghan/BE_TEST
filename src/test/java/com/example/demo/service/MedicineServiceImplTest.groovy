package com.example.demo.service

import com.example.demo.controller.request.MedicinePostRequest
import com.example.demo.controller.response.MedicinePostResponse
import com.example.demo.infrastructure.ServiceStatus
import com.example.demo.repository.MedicineRepository
import com.example.demo.service.impl.MedicineServiceImpl
import org.mockito.Mock
import spock.lang.Specification
import spock.lang.Unroll

class MedicineServiceImplTest extends Specification {

    MedicineRepository medicineRepository = Mock(MedicineRepository)
    MedicineServiceImpl medicineService = new MedicineServiceImpl(medicineRepository)

    @Unroll
    def "postRequest_test"() {
        setup:
        MedicinePostRequest medicinePostRequest = new MedicinePostRequest(id, name, price)

        def expect = new MedicinePostResponse(ServiceStatus.SUCCESS);

        when:
        def result = medicineService.postMedicine(medicinePostRequest)

        then:
        result == expect

        where:
        id | name | price
        // normal case: insert
        null | "bruh" | 1234556
        // update
        "MD_00001" | "brahhhh" | 123545
        // insert but with id: still insert with id auto generator
        "MD_12001" | "brahhhh" | 123545
        // null
        null | null | null
    }
}
