package com.cognizant.Authentication.Service;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;

import com.cognizant.Authentication.Exception.UserNotFoundException;

public interface ServiceAuth {
    @Retryable(value = { UserNotFoundException.class }, maxAttempts = 3, backoff = @Backoff(delay = 1000))
    boolean getAuthenticUser(String email, String password) throws UserNotFoundException;
}
