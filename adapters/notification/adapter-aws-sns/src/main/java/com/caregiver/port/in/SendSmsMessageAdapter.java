package com.caregiver.port.in;

import com.amazonaws.services.sns.model.PublishRequest;
import com.caregiver.config.AwsSnsClient;
import com.caregiver.user.port.out.NotificationSmsPort;
import lombok.RequiredArgsConstructor;

/**
 * SMS 문자 메세지를 보냅니다.
 */
@RequiredArgsConstructor
public class SendSmsMessageAdapter implements NotificationSmsPort {

  private final AwsSnsClient awsSnsClient;

  /**
   * SMS 문자메세지를 보냅니다.
   *
   * @param notificationSmsCommand SMS 요청.
   */
  @Override
  public void sendSmsMessage(NotificationSmsCommand notificationSmsCommand) {
    awsSnsClient.snsClient()
        .publish(
            new PublishRequest().withMessage(notificationSmsCommand.getMessage())
                .withPhoneNumber(notificationSmsCommand.concatCountryCodeMobile())
                .withMessageAttributes(awsSnsClient.getMessageAttributeValue())
        );
  }
}
