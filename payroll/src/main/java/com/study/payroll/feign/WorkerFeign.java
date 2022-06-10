package com.study.payroll.feign;

import com.study.payroll.entities.Worker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name="worker", path = "/workers")
public interface WorkerFeign {

    @GetMapping("{id}")
    ResponseEntity<Worker> getById(@PathVariable String id);
}
