package com.cognizant.Authentication.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.CircuitBreaker;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import com.cognizant.Authentication.Exception.UserNotFoundException;
import com.cognizant.Authentication.Model.UserAuth;
import com.cognizant.Authentication.Repository.RepositoryAuth;

@Service
public class ServiceImplAuth implements ServiceAuth {
    @Autowired
    RepositoryAuth authRepository;

    @Retryable(value = {UserNotFoundException.class}, maxAttempts = 3, backoff = @Backoff(delay = 1000))
    @CircuitBreaker(maxAttempts = 5, openTimeout = 2000, resetTimeout = 5000)
    @Override
    public boolean getAuthenticUser(String email, String password) throws UserNotFoundException {
     
        Optional<UserAuth> userInfo = authRepository.findByEmailAndPassword(email, password);
        if (userInfo.isPresent())
            return true;
        else
            throw new UserNotFoundException("User Not Found");
    }
}
