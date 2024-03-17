package com.cognizant.UserProfile.Service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cognizant.UserProfile.Exception.UserAlreadyExistException;
import com.cognizant.UserProfile.Exception.UserNotFoundException;
import com.cognizant.UserProfile.Model.User;
import com.cognizant.UserProfile.Repository.UserRepository;
import org.springframework.kafka.core.KafkaTemplate;

public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private KafkaTemplate<String,String> kafkaTemplate;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetUserById_UserExists() {
        Long userId = 1L;
        User user = new User();
        user.setId(userId);
        user.setName("Test User");
        user.setEmail("test@example.com");

        when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        User retrievedUser = userService.getUserById(userId);

        assertEquals(user, retrievedUser);
    }

    @Test
    public void testGetUserById_UserDoesNotExist() {
        Long userId = 1L;

        when(userRepository.findById(userId)).thenReturn(Optional.empty());

        User retrievedUser = userService.getUserById(userId);

        assertNull(retrievedUser);
    }

   

    @Test
    public void testAddUser_UserAlreadyExists() {
        User user = new User();
        user.setName("Test User");
        user.setEmail("test@example.com");

        when(userRepository.getUserByEmail("test@example.com")).thenReturn(Optional.of(user));

        assertThrows(UserAlreadyExistException.class, () -> userService.addUser(user));

        verify(userRepository, never()).save(user);
      
    }

    @Test
    public void testUpdateUser_UserExists() throws UserNotFoundException {
        Long userId = 1L;
        User existingUser = new User();
        existingUser.setId(userId);
        existingUser.setName("Existing User");
        existingUser.setEmail("existing@example.com");

        User updatedUser = new User();
        updatedUser.setId(userId);
        updatedUser.setName("Updated User");
        updatedUser.setEmail("updated@example.com");

        when(userRepository.findById(userId)).thenReturn(Optional.of(existingUser));
        when(userRepository.save(existingUser)).thenReturn(updatedUser);

        User result = userService.updateUser(updatedUser, userId);

        assertEquals(updatedUser, result);
        verify(userRepository, times(1)).findById(userId);
        verify(userRepository, times(1)).save(existingUser);
    }

    @Test
    public void testUpdateUser_UserNotFound() {
        Long userId = 1L;
        User updatedUser = new User();
        updatedUser.setId(userId);
        updatedUser.setName("Updated User");
        updatedUser.setEmail("updated@example.com");

        when(userRepository.findById(userId)).thenReturn(Optional.empty());

        assertThrows(UserNotFoundException.class, () -> userService.updateUser(updatedUser, userId));

        verify(userRepository, times(1)).findById(userId);
        verify(userRepository, never()).save(any());
    }

    @Test
    public void testDeleteUser_UserExists() {
        Long userId = 1L;

        userService.deleteUser(userId);

        verify(userRepository, times(1)).deleteById(userId);
    }

    @Test
    public void testDeleteUser_UserNotFound() {
        Long userId = 1L;

        doThrow(new RuntimeException()).when(userRepository).deleteById(userId);

        assertThrows(RuntimeException.class, () -> userService.deleteUser(userId));

        verify(userRepository, times(1)).deleteById(userId);
    }
}
