package com.cognizant.UserProfile.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.UserProfile.Model.User;
@Repository
public interface UserRepository extends JpaRepository<User,Long>{

	boolean existsByEmail(String email);
@Query("select u from User u WHERE u.email=?1")
Optional<User>getUserByEmail(String email);


}
