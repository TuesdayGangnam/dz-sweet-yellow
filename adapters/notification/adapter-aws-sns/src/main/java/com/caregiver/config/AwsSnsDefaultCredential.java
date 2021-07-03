package com.caregiver.config;


import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * AmazonSNS 객체를 생성합니다.
 * 기본 자격 증명을 사용 합니다.
 */
@Configuration
@RequiredArgsConstructor
public class AwsSnsDefaultCredential implements AwsSnsClientFactory {

  private final AwsProperties awsProperties;

  @Bean
  @Override
  public AmazonSNS createAmazonSns() {
    BasicAWSCredentials credentialsMaster = new BasicAWSCredentials(
        awsProperties.getAccessKey(), awsProperties.getSecretKey());

    AmazonSNSClientBuilder amazonSnsClientBuilder = AmazonSNSClientBuilder
        .standard()
        .withCredentials(new AWSStaticCredentialsProvider(credentialsMaster));
    amazonSnsClientBuilder.setRegion(awsProperties.getSigningRegion());

    return amazonSnsClientBuilder.build();
  }
}
