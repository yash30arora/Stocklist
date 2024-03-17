package com.cognizant.Authentication.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.Authentication.Model.UserAuth;
@Repository
public interface RepositoryAuth extends JpaRepository<UserAuth, String> {
	Optional<UserAuth> findByEmailAndPassword(String email, String password);
//Optional<UserAuth>save(String email, String password);
}
