package com.caregiver.user.port.in;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Optional;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 이미지 업로드 UseCase
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
    private final String dirName;

    public static RequestCommand of(File uploadFile, String dirName) {
      return new RequestCommand(uploadFile, dirName);
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
