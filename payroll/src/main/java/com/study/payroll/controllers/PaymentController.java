package com.study.payroll.controllers;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.study.payroll.entities.Payment;
import com.study.payroll.services.PaymentSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    PaymentSerivce paymentSerivce;

    @GetMapping("{workerId}/days/{days}")
    public ResponseEntity<Payment> getWorkerPayment(@PathVariable String workerId, @PathVariable int days){
        return ResponseEntity.status(HttpStatus.OK).body(paymentSerivce.getPayment(workerId, days));
    }

}
