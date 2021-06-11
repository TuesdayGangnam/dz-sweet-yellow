package com.caregiver.common.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.caregiver.common.util.AccreditationNumberUtil.generate;
import static org.assertj.core.api.Assertions.assertThat;

class AccreditationNumberUtilTest {

  @Test
  @DisplayName("4자리 인증번호 생성 테스트")
  public void createRandomAccreditationNumber() {
    assertThat(generate(1_000, 10_000)).isStrictlyBetween(999, 10_000);
    assertThat(1_000).isStrictlyBetween(999, 10_000);
    assertThat(9_999).isStrictlyBetween(999, 10_000);
  }

}
