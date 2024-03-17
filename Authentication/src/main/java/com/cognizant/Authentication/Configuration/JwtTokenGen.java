package com.cognizant.Authentication.Configuration;


import java.util.HashMap;
import java.util.Map;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.cognizant.Authentication.Model.UserAuth;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.validation.constraints.Email;

@Service
public class JwtTokenGen {
	public Map<String, String> generateToken(UserAuth user) {
        String jwtToken = "";
        /*
         * Generate JWT token and store in String jwtToken
         */
        Map<String, String> jwtTokenMap = new HashMap<>();
        Map<String, Object> userdata = new HashMap<>();
        userdata.put("email", user.getEmail());
        userdata.put("password", user.getPassword());
        jwtToken = Jwts.builder().setClaims(userdata)
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "secret").compact();
        jwtTokenMap.put("token", jwtToken);
        jwtTokenMap.put("email", user.getEmail());
        jwtTokenMap.put("message", "Login Successful");
        System.out.println("Token Generated");
        return jwtTokenMap;
    }

}
