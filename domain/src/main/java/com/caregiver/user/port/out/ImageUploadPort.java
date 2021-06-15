package com.caregiver.user.port.out;

import com.caregiver.user.port.in.ImageUploadUseCase.RequestCommand;
import com.caregiver.user.port.in.ImageUploadUseCase.ResponseCommand;

public interface ImageUploadPort {

  ResponseCommand upload(RequestCommand command);
}
