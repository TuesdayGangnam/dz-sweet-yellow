package com.caregiver.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AmazonS3Config {

  @Value("${cloud.aws.credentials.access-key:default-aws-access-key}")
  private String accessKey;

  @Value("${cloud.aws.credentials.secret-key:default-aws-secret-key}")
  private String secretKey;

  @Value("${cloud.aws.region.static}")
  private String region;

  @Getter
  @Value("${cloud.aws.s3.bucket}")
  private String bucket;

  @Getter
  @Value("${cloud.aws.s3.image-path}")
  private String imagePath;

  @Bean
  @Primary
  public BasicAWSCredentials awsCredentialsProvider() {
    return new BasicAWSCredentials(accessKey, secretKey);
  }

  @Bean
  public AmazonS3 amazonS3() {
    return AmazonS3ClientBuilder.standard()
        .withRegion(region)
        .withCredentials(new AWSStaticCredentialsProvider(awsCredentialsProvider()))
        .build();
  }
}
