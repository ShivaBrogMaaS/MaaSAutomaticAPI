package com.test.corent.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.test.corent.model.Client;

public interface ClientRepo extends JpaRepository<Client, Integer> 
{
@Query(value = "select name from security.user", nativeQuery = true)
List<Client> findByName();

@Query(value = "select * from security.client  where name =?1", nativeQuery = true)
List<Client> findAllByPo(@Param("name") String name);

}
