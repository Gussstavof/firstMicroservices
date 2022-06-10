package com.study.worker.services;

import com.study.worker.entities.Worker;
import com.study.worker.exceptions.NotFoundException;
import com.study.worker.repositories.WorkerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class WorkerServiceTest {

    @InjectMocks
    WorkerService workerService;

    @Mock
    WorkerRepository repository;

    List<Worker> workersList;

    Worker worker1;
    Worker worker2;


    @BeforeEach
    void setUp() {
         worker1 = new Worker("1",
                "Mario",
                200.00);
         worker2 = new Worker("2",
                "Luigi",
                300.00);

        workersList = new ArrayList<>();
        workersList.add(worker1);
        workersList.add(worker2);
    }

    @Test
    void getAllWorkers() {
        Mockito.when(repository.findAll())
                .thenReturn(workersList);

        assertEquals(2, Objects.requireNonNull(workerService.getAllWorkers()
              .getBody()).size());
    }

    @Test
    void getWorkersById() {
        Mockito.when(repository.findById("1"))
                .thenReturn(Optional.ofNullable(worker1));
        Mockito.when(repository.findById("2"))
                .thenReturn(Optional.ofNullable(worker2));



        assertEquals("Mario", Objects.requireNonNull(workerService.getWorkersById("1")
                .getBody()).getName());
        assertEquals("Luigi", Objects.requireNonNull(workerService.getWorkersById("2")
                .getBody()).getName());
    }

    @Test
    void getWorkersByIdNotFound() {
        Mockito.when(repository.findById(Mockito.anyString()))
                .thenThrow(new NotFoundException("ID not found"));

        Assertions.assertThrows(NotFoundException.class,() -> workerService.getWorkersById("7"));
    }
}