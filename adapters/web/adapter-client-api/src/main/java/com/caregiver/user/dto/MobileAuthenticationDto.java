package com.caregiver.user.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MobileAuthenticationDto {

  @Getter
  @NoArgsConstructor
  public static class Request {

    @NotBlank
    @Pattern(regexp = "(01[0-9])-(\\d{3,4})-(\\d{4})")
    private String mobile;

    public Request(String mobile) {
      this.mobile = mobile;
    }
  }

}
