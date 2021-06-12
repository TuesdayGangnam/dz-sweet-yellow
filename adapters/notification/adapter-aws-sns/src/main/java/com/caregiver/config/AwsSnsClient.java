package com.caregiver.config;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.MessageAttributeValue;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * AWS SNS Service를 이용하기 위한 Client.
 */
@Component
@RequiredArgsConstructor
public class AwsSnsClient {

  private final AwsSnsClientFactory awsSnsClientFactory;

  public AmazonSNS snsClient() {
    return awsSnsClientFactory.createAmazonSns();
  }

  public Map<String, MessageAttributeValue> getMessageAttributeValue() {
    return awsSnsClientFactory.messageAttributeValue();
  }

}
