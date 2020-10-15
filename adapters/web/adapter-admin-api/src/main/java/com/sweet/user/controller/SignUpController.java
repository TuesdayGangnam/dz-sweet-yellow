package com.sweet.user.controller;

import com.sweet.user.dto.SignUpDto;
import com.sweet.user.port.in.SignUpUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class SignUpController {


  private final SignUpUseCase signUpUseCase;

  @PostMapping("/user/sign-up")
  public ResponseEntity<?> signUp(@RequestBody SignUpDto.Request signInDto) {
    return ResponseEntity.status(HttpStatus.CREATED).body("hello");
  }

}
