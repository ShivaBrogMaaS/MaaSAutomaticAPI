package com.test.corent.dao;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.test.corent.model.User;

@Transactional
@Repository
public interface UserRepo extends JpaRepository<User, Integer> 
{

User findByName(String name);

@Modifying
@Query(value = "update security.user set password =?1 where email =?2", nativeQuery = true)
void findByForgotPassword(@Param("password") String password, @Param("email") String email);

@Query(value = "select *from security.user where name =?1 and password =?2", nativeQuery = true)
User findByPassword(@Param("name") String name, @Param("password") String password);

@Query(value = "select *from security.user where email =?1", nativeQuery = true)
List<User> findByEmail(@Param("email") String email);

@Modifying
@Query(value = "update security.user set password =?1 where password =?2", nativeQuery = true)
void findByChangePassword(@Param("newpassword") String newpassword, @Param("password") String password);

}
