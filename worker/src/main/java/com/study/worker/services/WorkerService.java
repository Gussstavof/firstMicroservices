package com.study.worker.services;

import com.study.worker.entities.Worker;
import com.study.worker.exceptions.NotFoundException;
import com.study.worker.repositories.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerService {

    @Autowired
    WorkerRepository repository;

    public ResponseEntity<List<Worker>> getAllWorkers(){
        return ResponseEntity.ok().body(repository.findAll());
    }

    public ResponseEntity<Worker> getWorkersById(String workerId){
        return ResponseEntity.ok(repository.findById(workerId)
                .orElseThrow(() -> new NotFoundException("ID not found")));
    }
}
