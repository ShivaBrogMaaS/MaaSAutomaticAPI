package com.test.corent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.corent.dao.TimeTrackerRepo;
import com.test.corent.model.TimeTracker;

@Service
@Transactional
public class TimeTrackerService {
@Autowired
private TimeTrackerRepo repo;

public List<TimeTracker> listAll() {
return repo.findAll();
}

public void save(TimeTracker tt) {
repo.save(tt);
}

public TimeTracker get(int id) {
return repo.findById(id).get();
}

public void delete(int id) {
repo.deleteById(id);
}
}
