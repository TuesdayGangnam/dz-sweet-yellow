package com.sweet.user.service;

import com.sweet.common.annotation.UseCase;
import com.sweet.user.port.command.SignUpCommand;
import com.sweet.user.port.in.SignUpUseCase;

@UseCase
public class SignUpService implements SignUpUseCase {

  @Override
  public void signUp(SignUpCommand signUpCommand) {

  }
}
