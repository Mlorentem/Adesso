package com.mylive.springcodingsession.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class GroupService {

	@Autowired
	private GroupRepository GroupRepository;

	public List<Group> retrieveAllGroups() {
		return GroupRepository.findAll();
	}

	public Optional<Group> retrieveGroup(int id) {
		Optional<Group> Group= GroupRepository.findById(id);
//		if(!Group.isPresent()) {
//			throw new GroupNotFoundException("Group not Found with id: "+id);
//		}
		
		return Group;
	}

	public ResponseEntity<Group> createGroup(Group Group) {
		GroupRepository.save(Group);
		return new ResponseEntity<>(Group, HttpStatus.CREATED);
	}
}