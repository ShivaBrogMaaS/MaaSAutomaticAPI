package com.test.corent.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.corent.model.Group;

public interface GroupRepo extends JpaRepository<Group, Integer> {

}
