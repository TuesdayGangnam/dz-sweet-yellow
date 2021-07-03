package com.caregiver.user.port.in;

import java.io.File;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 이미지 업로드 UseCase.
 */
public interface ImageUploadUseCase {

  /**
   * 주어진 이미지를 업로드 합니다.
   */
  ResponseCommand upload(RequestCommand command);

  @Getter
  @EqualsAndHashCode
  @RequiredArgsConstructor
  class RequestCommand {
    private final File uploadFile;

    public static RequestCommand of(File uploadFile) {
      return new RequestCommand(uploadFile);
    }
  }

  @Getter
  @EqualsAndHashCode
  @RequiredArgsConstructor
  class ResponseCommand {
    private final String uploadImageUrl;

    public static ResponseCommand of(String uploadImageUrl) {
      return new ResponseCommand(uploadImageUrl);
    }
  }
}
