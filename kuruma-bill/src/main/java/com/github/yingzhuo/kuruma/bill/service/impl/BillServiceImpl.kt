package com.github.yingzhuo.kuruma.bill.service.impl

import com.github.yingzhuo.kuruma.bill.mapper.dao.BillDao
import com.github.yingzhuo.kuruma.bill.service.BillService
import com.github.yingzhuo.kuruma.common.entity.Bill
import com.github.yingzhuo.kuruma.common.exception.ResourceNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service("billService")
open class BillServiceImpl @Autowired constructor(val billDao: BillDao): BillService {

    override fun findBillById(billId: String): Bill {
        return billDao.findBillById(billId) ?: throw ResourceNotFoundException()
    }

    override fun findBillsByUserId(userId: String): List<Bill> {
        return billDao.findBillsByUserId(userId)
    }

    override fun findBillsByCarId(carId: String): List<Bill> {
        return billDao.findBillsByCarId(carId)
    }

}
