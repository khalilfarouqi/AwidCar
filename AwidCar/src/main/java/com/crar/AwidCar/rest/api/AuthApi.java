package com.crar.AwidCar.rest.api;

import com.crar.AwidCar.jwt.payload.request.SignupRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@CrossOrigin
@RequestMapping("/api/auth")
public interface AuthApi {
    @PostMapping("/signup")
    ResponseEntity<?> authenticateUser(@Valid @RequestBody SignupRequest signupRequest);
}
