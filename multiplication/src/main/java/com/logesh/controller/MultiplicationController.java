package com.logesh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.logesh.model.Attempt;
import com.logesh.model.MultiplicationGenerator;
import com.logesh.service.MultiplicationGeneratorServiceImpl;

@RestController
@CrossOrigin
public class MultiplicationController {

	@Autowired
	private MultiplicationGeneratorServiceImpl svc;

	@GetMapping("/getTask")
	public MultiplicationGenerator generateTask() {
		return svc.generateTask();
	}

	@GetMapping("/tasks")
	public List<MultiplicationGenerator> findAllTasks() {
		return svc.getAllTasks();
	}

	@PostMapping("/postResponse")
	public String getUserResponse(@RequestBody JsonNode obj) {
		//System.out.println("received objet : " + obj.get("users.userName").toString());
		svc.saveUserResponse(obj);
		return "Got it";
	}
	
	@PostMapping("/getAllUserReponseByName")
	public List<Attempt> getAllUserResponseByName(@RequestBody String name){
		System.out.println("rq found : "+name);
		return svc.getAllUserResponseByName(name);
	}
	
}
