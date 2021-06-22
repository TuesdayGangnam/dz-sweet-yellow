
package com.caregiver.user.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.caregiver.common.util.AccreditationNumberUtil;
import com.caregiver.user.port.in.SendAccreditationNumberUsecase;
import com.caregiver.user.port.out.NotificationSmsPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@SuppressWarnings({"NonAsciiCharacters", "CheckStyle"})
@DisplayName("SendAccreditationNumberService 클래스")
class SendAccreditationNumberServiceTest {

  private SendAccreditationNumberUsecase sendAccreditationNumberService;

  @Mock
  NotificationSmsPort notificationSmsPort;

  @BeforeEach
  void init() {
    this.sendAccreditationNumberService = new SendAccreditationNumberService(notificationSmsPort);
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
    @DisplayName("휴대폰 번호로 호출 되었을 경우")
    class Context_01 {

      private final int origin = 1_000;
      private final int bound = 10_000;

      @Test
      @DisplayName("인증번호를 생성한다")
      public void it_01() {
        final String 휴대폰_번호 = "010-1234-5678";
        final int 인증번호 = 1234;

        subject(휴대폰_번호);

        try (MockedStatic<AccreditationNumberUtil> utilities =
                 Mockito.mockStatic(AccreditationNumberUtil.class)) {

          utilities.when(() -> AccreditationNumberUtil.generate(origin, bound))
              .thenReturn(인증번호);

          assertThat(AccreditationNumberUtil.generate(origin, bound)).isEqualTo(인증번호);

        }
      }
    }
  }

}
