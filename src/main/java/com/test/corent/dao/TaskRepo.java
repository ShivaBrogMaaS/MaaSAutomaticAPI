package com.test.corent.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.corent.model.Task;

public interface TaskRepo extends JpaRepository<Task, Integer> {

}
