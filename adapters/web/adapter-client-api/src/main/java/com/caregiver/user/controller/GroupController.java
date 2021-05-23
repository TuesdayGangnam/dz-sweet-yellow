package com.caregiver.user.controller;

import com.caregiver.user.dto.GroupDto;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 모임 컨트롤러
 */
@RequestMapping("/v1/group")
public class GroupController {

  /**
   * 모임 생성을 요청합니다.
   *
   * @param request 모임생성 요청
   */
  @PostMapping("")
  public ResponseEntity create(
      @RequestBody @Valid GroupDto.CreateRequest request) {

    return ResponseEntity
        .status(HttpStatus.CREATED)
        .build();
  }
}
