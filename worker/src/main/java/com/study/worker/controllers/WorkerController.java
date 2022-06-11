package com.study.worker.controllers;

import com.study.worker.entities.Worker;
import com.study.worker.services.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RefreshScope
@RestController
@RequestMapping(value = "/workers")
public class WorkerController {

    @Autowired
    WorkerService service;

    @Value("${test.config}")
    private String config;


    @GetMapping("/all")
    public ResponseEntity<List<Worker>> getAllWorkers(){
        return service.getAllWorkers();
    }

    @GetMapping("{id}")
    public ResponseEntity<Worker> getById(@PathVariable String id){
        return service.getWorkersById(id);
    }

    @GetMapping("/config")
    public ResponseEntity<String> getConfig(){
        return ResponseEntity.ok().body(this.config);
    }

}
