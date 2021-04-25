package com.caregiver.user.port.in;

import com.caregiver.user.port.command.SignUpCommand;

/**
 * 유저 가입 UseCase
 */
public interface SignUpUseCase {

  /**
   * 유저를 가입시킵니다.
   * @param signUpCommand 유저 가입 요청
   */
  void signUp(SignUpCommand signUpCommand);

}
