package com.sweet.user.dto;

import com.sweet.user.port.command.SignUpCommand;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SignUpDto {

  @Getter
  public static class Request {
    private String userName;
    private String password;

    public SignUpCommand toCommand() {
      return new SignUpCommand(this.userName, this.password);
    }
  }
}
