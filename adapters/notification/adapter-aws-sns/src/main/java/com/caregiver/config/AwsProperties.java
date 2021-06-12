package com.caregiver.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * SNS 서비스를 사용하기위한 properties 클래스입니다.
 */
@Getter
@Component
public class AwsProperties {

  @Value("${caregiver.aws.access-key:default-aws-access-key}")
  private String accessKey;

  @Value("${caregiver.aws.secret-key:default-aws-secret-key}")
  private String secretKey;

  @Value("${caregiver.aws.signing-region}")
  private String signingRegion;

  @Value("${caregiver.aws.sns.arn}")
  private String arn;

}
