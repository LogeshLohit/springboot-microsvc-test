package com.logesh.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.logesh.model.MultiplicationGenerator;
import com.logesh.repository.MultiplicationGeneratorRepository;

@Service
public class MultiplicationGeneratorServiceImpl {
	@Autowired
	private MultiplicationGeneratorRepository repo;

	public MultiplicationGenerator generateTask() {
		int factorA = new Random().nextInt(10) + 1;
		int factorB = new Random().nextInt(10) + 1;
		int result = factorA * factorB;
		MultiplicationGenerator multiplicationTask = new MultiplicationGenerator(factorA, factorB, result);
		repo.save(multiplicationTask);
		return multiplicationTask;
	}

	public List<MultiplicationGenerator> getAllTasks() {
		// TODO Auto-generated method stub
		List<MultiplicationGenerator> tasks = new ArrayList<>();
		repo.findAll().forEach(tasks::add);
		return tasks;
	}

	public void saveUserResponse(JsonNode obj) {
		// TODO Auto-generated method stub
		
	}
}
