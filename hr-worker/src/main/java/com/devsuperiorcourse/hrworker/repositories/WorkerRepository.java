package com.devsuperiorcourse.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperiorcourse.hrworker.entities.Worker;


public interface WorkerRepository extends JpaRepository<Worker, Long>{

}
