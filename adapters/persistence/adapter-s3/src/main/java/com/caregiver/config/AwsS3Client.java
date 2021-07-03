package com.caregiver.config;

import com.amazonaws.services.s3.AmazonS3;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * AWS S3 Service를 이용하기 위한 Client.
 */
@Component
@RequiredArgsConstructor
public class AwsS3Client {

  private final AmazonS3ClientFactory amazonS3ClientFactory;

  public AmazonS3 s3Client() {
    return amazonS3ClientFactory.createAmazonS3();
  }

}
