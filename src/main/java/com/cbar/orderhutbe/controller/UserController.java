package com.cbar.orderhutbe.controller;

import com.cbar.orderhutbe.model.User;
import com.cbar.orderhutbe.repository.UserRepository;
import com.cbar.orderhutbe.security.JwtTokenProvider;
import com.cbar.orderhutbe.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Base64;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider tokenProvider;
    private final UserRepository userRepository;

    public UserController(UserService userService, AuthenticationManager authenticationManager, JwtTokenProvider tokenProvider, UserRepository userRepository) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.tokenProvider = tokenProvider;
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        JSONObject jsonObject = new JSONObject();
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword()));
            if(authentication.isAuthenticated()) {
                String username = user.getUserName();
                jsonObject.put("username", authentication.getName());
                jsonObject.put("authorities", authentication.getAuthorities());
                jsonObject.put("role", userRepository.findByUserName(username).getRole());
                jsonObject.put("token", tokenProvider.createToken(username, userRepository.findByUserName(username).getRole()));
                return ResponseEntity.ok().body(jsonObject.toString());
            }
        } catch (JSONException e) {
            try {
                jsonObject.put("exception", e.getMessage());
            } catch (JSONException e1) {
                e1.printStackTrace();
            }
            return new ResponseEntity<>(jsonObject.toString(), HttpStatus.UNAUTHORIZED);
        }
        return null;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> retrieveUserById(@PathVariable int userId) {
        return ResponseEntity.ok()
                .body(userService.retrieveUserById(userId));
    }
}
