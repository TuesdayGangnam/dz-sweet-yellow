package com.caregiver.user.port.in;

import com.caregiver.common.SelfValidating;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;


/**
 * 인증 번호 전송 Usecase
 */
public interface SendAccreditationNumberUsecase {

  /**
   * 주어진 휴대폰 번호를 SMS 발송서버로 전송합니다.
   */
  void send(SendAccreditationNumberCommand sendAccreditationNumberCommand);


  @EqualsAndHashCode(callSuper = false)
  class SendAccreditationNumberCommand extends SelfValidating<SendAccreditationNumberCommand> {

    @NotBlank
    private final String mobile;

    public SendAccreditationNumberCommand(String mobile) {
      this.mobile = mobile;
      this.validateSelf();
    }
  }
}
