package com.cognizant.UserProfile.Controller;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.cognizant.UserProfile.Exception.UserAlreadyExistException;
import com.cognizant.UserProfile.Exception.UserNotFoundException;
import com.cognizant.UserProfile.Model.User;
import com.cognizant.UserProfile.Service.UserService;

public class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Test
    public void testGetUserById() {
        // Arrange
        Long userId = 1L;
        User mockUser = new User(userId,  "John Doe","Shubham", "john@example.com","India");
        Mockito.when(userService.getUserById(userId)).thenReturn(mockUser);

        // Act
        ResponseEntity<User> responseEntity = userController.getUserById(userId);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertEquals(userId, responseEntity.getBody().getUserid());
        assertEquals("John Doe", responseEntity.getBody().getName());
        assertEquals("john@example.com", responseEntity.getBody().getEmail());
    }

//    @Test
//    public void testGetUserProfileByEmail() {
//        // Arrange
//        String email = "dalvi@gmail.com";
//        User mockUser = new User(1L,"John Doe","Shubham", email,"India");
//        Mockito.when(userService.getUserByEmail(email)).thenReturn(Optional.of(mockUser));
//
//        // Act
//        ResponseEntity<Object> responseEntity = userController.getUserProfileByEmail(email);
//
//        // Assert
//        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
//        assertNotNull(responseEntity.getBody());
//        assertTrue(responseEntity.getBody() instanceof User);
//        User resultUser = (User) responseEntity.getBody();
//        assertEquals("John Doe", resultUser.getName());
//        assertEquals(email, resultUser.getEmail());
//    }

    @Test
    public void testAddUser() throws UserAlreadyExistException {
        // Arrange
        User newUser = new User(null,  "Shubham","Shubham", "dalvi@gmail.com","India");
        Mockito.when(userService.addUser(newUser)).thenReturn(newUser);

        // Act
        ResponseEntity<?> responseEntity = userController.addUser(newUser);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertTrue(responseEntity.getBody() instanceof User);
        User resultUser = (User) responseEntity.getBody();
        assertEquals("Shubham", resultUser.getName());
        assertEquals("dalvi@gmail.com", resultUser.getEmail());
    }
    
    @Test
    public void testUpdateUser() {
        // Arrange
        long userId = 1L;
        User updatedUserRequest = new User(userId,"Shubham","Shubham", "dalvi@gmail.com","India");
        User updatedUserResponse = new User(userId, "Shubham","Shubham", "dalvi@gmail.com","India");
        Mockito.when(userService.updateUser(updatedUserRequest, userId)).thenReturn(updatedUserResponse);

        // Act
        ResponseEntity<?> responseEntity = userController.updateUser(updatedUserRequest, userId);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertTrue(responseEntity.getBody() instanceof User);
        User resultUser = (User) responseEntity.getBody();
        assertEquals(userId, resultUser.getUserid());
        assertEquals("Shubham", resultUser.getName());
        assertEquals("dalvi@gmail.com", resultUser.getEmail());
    }
    
    @Test
    public void testUpdateUserWhenUserNotFound() {
        // Arrange
        long userId = 2L;
        User updatedUserRequest = new User(userId,"Shubham","Shubham", "dalvi@gmail.com","India");
        Mockito.when(userService.updateUser(updatedUserRequest, userId))
               .thenThrow(new UserNotFoundException("User not found"));

        // Act
        ResponseEntity<?> responseEntity = userController.updateUser(updatedUserRequest, userId);

        // Assert
        assertEquals(HttpStatus.CONFLICT, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertEquals("user not found", responseEntity.getBody());
    }
    
    @Test
    public void testDeleteUser() {
        // Arrange
        long userId = 1L;
        Mockito.when(userService.deleteUser(userId)).thenReturn("User deleted successfully");

        // Act
        ResponseEntity<String> responseEntity = userController.deleteUser(userId);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertEquals("User deleted successfully", responseEntity.getBody());
    }
    // Similar test cases for updateUser and deleteUser methods

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
}
