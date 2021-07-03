package com.caregiver.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


/**
 * AmazonS3 객체를 생성합니다.
 * 기본 자격 증명을 사용 합니다.
 */
@Configuration
@RequiredArgsConstructor
public class AwsS3DefaultCredential implements AmazonS3ClientFactory {

  private final AmazonS3Config amazonS3Config;

  /**
   * AWS 기본 인증이 완료된 Bean을 리턴합니다.
   */
  @Bean
  @Primary
  public BasicAWSCredentials awsCredentialsProvider() {
    return new BasicAWSCredentials(amazonS3Config.getAccessKey(), amazonS3Config.getSecretKey());
  }

  @Bean
  @Override
  public AmazonS3 createAmazonS3() {
    return AmazonS3ClientBuilder.standard()
        .withRegion(amazonS3Config.getRegion())
        .withCredentials(new AWSStaticCredentialsProvider(awsCredentialsProvider()))
        .build();
  }

}
