package com.caregiver.user.service;

import com.caregiver.common.annotation.UseCase;
import com.caregiver.user.port.in.SendAccreditationNumberUsecase;

import static com.caregiver.common.util.AccreditationNumberUtil.generate;

/**
 * 인증번호 전송 service
 */
@UseCase
public class SendAccreditationNumberService implements SendAccreditationNumberUsecase {

  @Override
  public void send(SendAccreditationNumberCommand sendAccreditationNumberCommand) {

    final var accreditationNumber = generate(100_000, 1000_000);

  }

}
