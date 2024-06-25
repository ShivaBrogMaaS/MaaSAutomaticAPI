package com.test.corent.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.corent.model.FileDB;

@Repository
public interface FileDBRepository extends JpaRepository<FileDB, String> {

}