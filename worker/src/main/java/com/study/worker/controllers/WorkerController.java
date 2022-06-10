package com.study.worker.controllers;

import com.study.worker.entities.Worker;
import com.study.worker.services.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/workers")
public class WorkerController {

    @Autowired
    WorkerService service;

    @GetMapping("/all")
    public ResponseEntity<List<Worker>> getAllWorkers(){
        return service.getAllWorkers();
    }

    @GetMapping("{id}")
    public ResponseEntity<Worker> getById(@PathVariable String id){
        return service.getWorkersById(id);
    }
}
