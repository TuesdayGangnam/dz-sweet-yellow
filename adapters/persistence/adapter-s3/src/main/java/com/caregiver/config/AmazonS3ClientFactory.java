package com.caregiver.config;


import com.amazonaws.services.s3.AmazonS3;

/**
 * <p> AWS S3 를 사용하기 위한 객체를 생성합니다.</p>
 * Spring profile 구분 별로 다른 자격 증명 방식을 사용하고 있습니다.
 * 기본 자격 증명 방식 과 IAM ROLE 자격증명 방식을 사용합니다.
 *
 * @see <a href="https://docs.aws.amazon.com/sdk-for-java/v1/developer-guide/credentials.html">
 * Setting Credentials</a>
 */
public interface AmazonS3ClientFactory {


  /**
   * S3 서비스 클라이언트 AmazonS3 리턴합니다.
   */
  AmazonS3 createAmazonS3();

}
