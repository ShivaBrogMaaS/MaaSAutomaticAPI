package com.test.corent.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.corent.model.TimeTracker;

public interface TimeTrackerRepo extends JpaRepository<TimeTracker, Integer> {

}
