package com.study.payroll.services;

import com.study.payroll.entities.Payment;
import com.study.payroll.entities.Worker;
import com.study.payroll.feign.WorkerFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class PaymentSerivce {

    @Autowired
    WorkerFeign workerFeign;

    public Payment getPayment(String workerId, int days){
        Worker worker = workerFeign.getById(workerId).getBody();
        return new Payment(Objects.requireNonNull(worker).getName(), worker.getDailyIncome(), days);
    }
}
