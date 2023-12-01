package com.mylive.springcodingsession.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GroupController {
	
	@Autowired
	GroupService groupService;
	
	@GetMapping(value = "/groupTest/groups", produces="application/json")
	public List<Group> retrieveAllGroups() {
		return groupService.retrieveAllGroups();
	}
	
	@GetMapping(value = "/groupTest/group/{id}", produces="application/json")
	public Optional<Group> retrieveGroup(@PathVariable("id") int id) {
		return groupService.retrieveGroup(id);
	}

	@PostMapping("/groupTest/group")
	public ResponseEntity<Group> createGroup(@RequestBody Group group) {
		return groupService.createGroup(group);
	}
}
