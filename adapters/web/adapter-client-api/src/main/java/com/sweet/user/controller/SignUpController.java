package com.sweet.user.controller;

import com.sweet.user.common.ApiResponseModel;
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

  /**
   * 회원을 가입 시킵니다.
   *
   * @param signInDto 회원 가입 DTO
   */
  @PostMapping("/user/sign-up")
  public ResponseEntity<?> signUp(@RequestBody SignUpDto.Request signInDto) {
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(new ApiResponseModel<>(true, "정상적으로 회원가입이 완료되었습니다.", null));
  }

}
