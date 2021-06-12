package com.caregiver.config;

import static org.assertj.core.api.Assertions.assertThat;

import com.amazonaws.regions.Regions;
import com.caregiver.common.BaseConfiguration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@SuppressWarnings("NonAsciiCharacters")
class AwsPropertiesTest extends BaseConfiguration {

  @Autowired
  AwsProperties awsProperties;

  @Test
  @DisplayName("Aws 설정정보를 확인하라")
  public void Aws_설정정보를_확인하라() {

    assertThat(awsProperties.getSigningRegion()).isEqualTo(Regions.AP_NORTHEAST_1.getName());
    assertThat(awsProperties.getArn()).isNotBlank();
    assertThat(awsProperties.getAccessKey()).isNotBlank();
    assertThat(awsProperties.getSecretKey()).isNotBlank();

  }


}
