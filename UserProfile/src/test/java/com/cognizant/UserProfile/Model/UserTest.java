package com.cognizant.UserProfile.Model;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class UserTest {
	 @Test
	    public void testUserConstructorAndGetters() {
	        // Arrange
	        Long userId = 1L;
	        String name = "Shubham";
	        String password = "password123";
	        String email = "dalvi@gmail.com";
	        String country = "India";

	        // Act
	        User user = new User(userId, name, password, email, country);

	        // Assert
	        assertThat(user.getUserid()).isEqualTo(userId);
	        assertThat(user.getName()).isEqualTo(name);
	        assertThat(user.getPassword()).isEqualTo(password);
	        assertThat(user.getEmail()).isEqualTo(email);
	        assertThat(user.getCountry()).isEqualTo(country);
	    }

	    @Test
	    public void testDefaultConstructorAndSetters() {
	        // Arrange
	        User user = new User();

	        // Act
	        user.setUserid(2L);
	        user.setName("Shubham");
	        user.setPassword("password456");
	        user.setEmail("dalvi@gmail.com");
	        user.setCountry("India");

	        // Assert
	        assertThat(user.getUserid()).isEqualTo(2L);
	        assertThat(user.getName()).isEqualTo("Shubham");
	        assertThat(user.getPassword()).isEqualTo("password456");
	        assertThat(user.getEmail()).isEqualTo("dalvi@gmail.com");
	        assertThat(user.getCountry()).isEqualTo("India");
	    }

	    // Add more test cases as needed

	}

