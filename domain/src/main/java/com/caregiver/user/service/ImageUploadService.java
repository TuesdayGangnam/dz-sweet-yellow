package com.caregiver.user.service;

import com.caregiver.common.annotation.UseCase;
import com.caregiver.user.port.in.ImageUploadUseCase;
import com.caregiver.user.port.out.ImageUploadPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@UseCase
public class ImageUploadService implements ImageUploadUseCase {

  private final ImageUploadPort imageUploadPort;

  @Override
  public ResponseCommand upload(RequestCommand command) {
    imageUploadPort.upload(command);

    return ResponseCommand.of("임시업로드URL");
  }
}
