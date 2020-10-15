package com.sweet.user.port.command;

import lombok.Builder;

/**
 * 유저 가입 요청.
 */
public class SignUpCommand {
  private final String userName;
  private final String password;

  @Builder
  public SignUpCommand(String userName, String password) {
    this.userName = userName;
    this.password = password;
  }
}
