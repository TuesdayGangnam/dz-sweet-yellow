package com.caregiver.user.port.out;

import com.caregiver.user.port.in.ImageUploadUseCase.RequestCommand;
import com.caregiver.user.port.in.ImageUploadUseCase.ResponseCommand;

/**
 * 이미지를 업로드하기 위한 Port.
 */
public interface ImageUploadPort {

  ResponseCommand upload(RequestCommand command);
}
