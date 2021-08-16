package com.devsuperiorcourse.hrworker.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperiorcourse.hrworker.entities.Worker;
import com.devsuperiorcourse.hrworker.exceptions.WorkerNotFound;
import com.devsuperiorcourse.hrworker.repositories.WorkerRepository;
import com.devsuperiorcourse.hrworker.utils.MessageUtil;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {
	
	@Autowired
	private WorkerRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAll() {
		List<Worker> list = repository.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id) {
		 Worker wk = repository.findById(id).orElseThrow(() -> new WorkerNotFound(MessageUtil.WORKER_NOT_FOUND));
		 return ResponseEntity.ok(wk);
		 
	}
}
