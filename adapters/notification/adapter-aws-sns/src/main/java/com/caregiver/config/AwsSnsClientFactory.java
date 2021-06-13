package com.caregiver.config;


import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.MessageAttributeValue;
import java.util.Map;

/**
 * <p> AWS SNS 를 사용하기 위한 객체를 생성합니다.</p>
 * Spring profile 구분 별로 다른 자격 증명 방식을 사용하고 있습니다.
 * 기본 자격 증명 방식 과 IAM ROLE 자격증명 방식을 사용합니다.
 *
 * @see <a href="https://docs.aws.amazon.com/sdk-for-java/v1/developer-guide/credentials.html">
 * Setting Credentials</a>
 */
public interface AwsSnsClientFactory {

  /**
   * SNS 서비스 클라이언트 AmazonSNS 리턴합니다.
   */
  AmazonSNS createAmazonSns();

  /**
   * 메세지 전송 속성 값 을 리턴합니다.
   * <a href='https://docs.aws.amazon.com/ko_kr/sns/latest/dg/sms_publish-to-phone.html#sms_publish_sdk'></a>
   */
  default Map<String, MessageAttributeValue> messageAttributeValue() {
    return Map.of(
        "AWS.SNS.SMS.SenderID",
        new MessageAttributeValue().withStringValue("mySenderId").withDataType("String"),
        "AWS.SNS.SMS.MaxPrice",
        new MessageAttributeValue().withStringValue("0.50").withDataType("String"),
        "AWS.SNS.SMS.SMSType",
        new MessageAttributeValue().withStringValue("Promotional").withDataType("String"));
  }

}
