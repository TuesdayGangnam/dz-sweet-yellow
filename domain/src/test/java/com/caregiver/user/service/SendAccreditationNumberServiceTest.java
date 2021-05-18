
package com.caregiver.user.service;

import com.caregiver.common.util.AccreditationNumberUtil;
import com.caregiver.user.port.in.SendAccreditationNumberUsecase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
@DisplayName("SendAccreditationNumberService 클래스")
class SendAccreditationNumberServiceTest {

  private SendAccreditationNumberUsecase sendAccreditationNumberService;

  @BeforeEach
  void init() {
    this.sendAccreditationNumberService = new SendAccreditationNumberService();
  }

  @Nested
  @DisplayName("send 메소드는")
  class Describe_01 {

    public void subject(String mobileNumber) {
      final var command = new SendAccreditationNumberUsecase
          .SendAccreditationNumberCommand(mobileNumber);

      sendAccreditationNumberService.send(command);
    }

    @Nested
    @DisplayName("가입되지 않은 휴대폰 번호로 호출 되었을 경우")
    class Context_01 {

      private final int origin = 100_000;
      private final int bound = 1000_000;

      @Test
      @DisplayName("인증번호를 생성한다")
      public void it_01() {
        final String 가입되지_않은_휴대폰_번호 = "010-1234-5678";
        final int 인증번호 = 123456;

        subject(가입되지_않은_휴대폰_번호);

        try (MockedStatic<AccreditationNumberUtil> utilities =
                 Mockito.mockStatic(AccreditationNumberUtil.class)) {
          utilities.when(() -> AccreditationNumberUtil.generate(origin, bound))
              .thenReturn(인증번호);

          assertThat(AccreditationNumberUtil
              .generate(origin, bound)).isEqualTo(인증번호);

        }
      }
    }
  }

}
