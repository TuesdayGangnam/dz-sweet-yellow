package com.caregiver.sms;

import static org.assertj.core.api.Assertions.assertThat;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.MessageAttributeValue;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;
import com.caregiver.common.BaseConfiguration;
import com.caregiver.config.AwsSnsClient;
import java.util.Map;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 문자메세지 발송 테스트.
 */
@SuppressWarnings({"NonAsciiCharacters", "CheckStyle"})
public class SendSmsMessageAdapterTest extends BaseConfiguration {

  @Autowired
  AwsSnsClient awsSnsClient;

  /**
   * 테스트가 실행될 경우 SMS 문자 메세지를 발송합니다.
   * 과금이 발생 요소가 있기에 Disabled 처리합니다.
   * TODO 테스트 코드 목킹 그리고 리팩토링
   */
  @Test
  @Disabled
  @DisplayName("aws Sms 메일 발송을 테스트하라")
  public void aws_sms_메일_발송을_테스트하라() {

    final var snsClient = awsSnsClient.snsClient();

    final var publishResult = sendSmsMessage(snsClient, "안녕하세요 이지훈입니다. 문자메세지 테스트",
        "+8201012345678", awsSnsClient.getMessageAttributeValue());

    assertThat(publishResult.getMessageId()).isNotBlank();
  }

  private PublishResult sendSmsMessage(AmazonSNS amazonSns, String message, String phoneNumber,
                                       Map<String, MessageAttributeValue> smsAttributes) {

    return amazonSns.publish(new PublishRequest().withMessage(message)
        .withPhoneNumber(phoneNumber)
        .withMessageAttributes(smsAttributes));

  }

}
