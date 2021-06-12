package com.caregiver.config;


import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import com.amazonaws.services.sns.model.MessageAttributeValue;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * AmazonSNS 객체를 생성합니다.
 * 기본 자격 증명을 사용 합니다.
 */
@Configuration
@RequiredArgsConstructor
@SuppressWarnings("SpringFacetCodeInspection")
public class AwsDefaultCredential implements AwsSnsClientFactory {

  private final AwsProperties awsProperties;

  @Bean
  @Override
  public AmazonSNS createSnsClient() {
    BasicAWSCredentials credentialsMaster = new BasicAWSCredentials(
        awsProperties.getAccessKey(), awsProperties.getSecretKey());

    AmazonSNSClientBuilder amazonSnsClientBuilder = AmazonSNSClientBuilder
        .standard()
        .withCredentials(new AWSStaticCredentialsProvider(credentialsMaster));
    amazonSnsClientBuilder.setRegion(awsProperties.getSigningRegion());

    return amazonSnsClientBuilder.build();
  }

  /**
   * 메세지 전송 속성 값 을 가진 빈을 리턴합니다.
   * <a href='https://docs.aws.amazon.com/ko_kr/sns/latest/dg/sms_publish-to-phone.html#sms_publish_sdk'></a>
   */
  @Bean
  public Map<String, MessageAttributeValue> messageAttributeValue() {
    return Map.of(
        "AWS.SNS.SMS.SenderID",
        new MessageAttributeValue().withStringValue("mySenderId").withDataType("String"),
        "AWS.SNS.SMS.MaxPrice",
        new MessageAttributeValue().withStringValue("0.50").withDataType("String"),
        "AWS.SNS.SMS.SMSType",
        new MessageAttributeValue().withStringValue("Promotional").withDataType("String"));
  }

}
