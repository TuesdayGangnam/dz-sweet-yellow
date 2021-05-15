package com.caregiver.user.port.in;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolationException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SuppressWarnings("NonAsciiCharacters")
@DisplayName("SendAccreditationNumberCommand 클래스")
class SendAccreditationNumberCommandTest {

  @Nested
  @DisplayName("SendAccreditationNumberCommand 생성자는")
  class Describe_01 {

    private void subject(String mobileNumber) {
      SendAccreditationNumberUsecase.SendAccreditationNumberCommand sendAccreditationNumberCommand =
          new SendAccreditationNumberUsecase.SendAccreditationNumberCommand(mobileNumber);
    }

    @Nested
    @DisplayName("휴대폰 번호가 null이 주어질 경우")
    class Context_01 {

      private final String null_인_휴대폰번호 = null;

      @Test
      @DisplayName("예외를 리턴한다.")
      public void it_01() {
        assertThatThrownBy(() -> subject(null_인_휴대폰번호))
            .isInstanceOf(ConstraintViolationException.class);
      }

    }

    @Nested
    @DisplayName("공백 또는 빈 휴대폰 번호가 주어질 경우")
    class Context_02 {

      private final List<String> mobileNumbers = List.of("", "    ");

      @Test
      @DisplayName("예외를 리턴한다.")
      public void it_01() {
        mobileNumbers
            .forEach(mobileNumber -> assertThatThrownBy(() -> subject(mobileNumber))
                .isInstanceOf(ConstraintViolationException.class));

      }

    }

  }

}
