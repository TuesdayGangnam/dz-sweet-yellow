package com.caregiver.common;

import com.caregiver.config.AwsDefaultCredential;
import com.caregiver.config.AwsProperties;
import com.caregiver.config.AwsSnsClient;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * 테스트를 클래스에서 공통으로 필요로하는 정보를 관리하는 클래스.
 */
@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {AwsProperties.class, AwsDefaultCredential.class,
    AwsSnsClient.class},
    initializers = ConfigFileApplicationContextInitializer.class)
public class BaseConfiguration {

}
