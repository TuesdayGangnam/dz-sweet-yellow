package com.caregiver.user.service;

import com.caregiver.common.annotation.UseCase;
import com.caregiver.user.port.command.SignUpCommand;
import com.caregiver.user.port.in.SignUpUseCase;

@UseCase
public class SignUpService implements SignUpUseCase {

  @Override
  public void signUp(SignUpCommand signUpCommand) {

  }
}
