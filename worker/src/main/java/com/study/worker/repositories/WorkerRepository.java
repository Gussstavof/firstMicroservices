package com.study.worker.repositories;


import com.study.worker.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

    Optional<Worker> findById(String workerId);

}
