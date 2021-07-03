package com.caregiver.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * S3 환경 변수 Configuration.
 */
@Getter
@Component
public class AmazonS3Properties {

  @Value("${cloud.aws.credentials.access-key:default-aws-access-key}")
  private String accessKey;

  @Value("${cloud.aws.credentials.secret-key:default-aws-secret-key}")
  private String secretKey;

  @Value("${cloud.aws.region.static}")
  private String region;

  @Value("${cloud.aws.s3.bucket}")
  private String bucket;

  @Value("${cloud.aws.s3.image-path}")
  private String imagePath;

}
