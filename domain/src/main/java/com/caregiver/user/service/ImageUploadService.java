package com.caregiver.user.service;

import com.caregiver.common.annotation.UseCase;
import com.caregiver.user.port.in.ImageUploadUseCase;
import com.caregiver.user.port.out.ImageUploadPort;
import lombok.RequiredArgsConstructor;

/**
 * 이미지 업로드 service.
 */
@RequiredArgsConstructor
@UseCase
public class ImageUploadService implements ImageUploadUseCase {

  private final ImageUploadPort imageUploadPort;

  @Override
  public ResponseCommand upload(RequestCommand command) {
    imageUploadPort.upload(command);
    // TODO: 응답값을 정의한 후 반환하는 코드 작성
    return ResponseCommand.of("임시업로드URL");
  }
}
