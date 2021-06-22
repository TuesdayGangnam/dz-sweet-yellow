package com.caregiver.user.service;

import static com.caregiver.common.util.AccreditationNumberUtil.generate;

import com.caregiver.common.annotation.UseCase;
import com.caregiver.user.port.in.SendAccreditationNumberUsecase;
import com.caregiver.user.port.out.NotificationSmsPort;
import lombok.RequiredArgsConstructor;

/**
 * 인증번호 전송 service.
 */
@UseCase
@RequiredArgsConstructor
public class SendAccreditationNumberService implements SendAccreditationNumberUsecase {

  private final NotificationSmsPort notificationSmsPort;
  private static final String COUNTRY_CODE = "+82";

  @Override
  public void send(SendAccreditationNumberCommand sendAccreditationNumberCommand) {

    final var accreditationNumber = generate(1_000, 10_000);

    notificationSmsPort.sendSmsMessage(
        new NotificationSmsPort.NotificationSmsCommand(
            accreditationNumberSmsMessage(accreditationNumber),
            sendAccreditationNumberCommand.getMobile(),
            COUNTRY_CODE
        )
    );

  }

  private String accreditationNumberSmsMessage(int accreditationNumber) {
    return "[집사살롱] 집사살롱 인증번호 [" + accreditationNumber + "] 요청하신 인증번호를 입력해 주세요.";
  }

}
