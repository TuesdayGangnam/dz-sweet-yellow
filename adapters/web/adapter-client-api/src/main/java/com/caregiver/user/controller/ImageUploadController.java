package com.caregiver.user.controller;

import com.caregiver.user.port.in.ImageUploadUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/v1/image")
@RequiredArgsConstructor
public class ImageUploadController {

  private final ImageUploadUseCase imageUploadUseCase;

  @PostMapping("/upload")
  public ResponseEntity<?> acceptAccreditationNumber(
      @RequestParam("data") MultipartFile multipartFile) throws IOException {

    File file = convert(multipartFile)
        .orElseThrow(() -> new IllegalArgumentException("MultipartFile -> File로 전환이 실패했습니다."));

    imageUploadUseCase.upload(ImageUploadUseCase.RequestCommand.of(file, "static"));

    return ResponseEntity
        .status(HttpStatus.CREATED)
        .build();
  }

    /**
     *
     * @param file
     * @return
     * @throws IOException
     */
  private Optional<File> convert(MultipartFile file) throws IOException {
    File convertFile = new File(file.getOriginalFilename());
    if (convertFile.createNewFile()) {
      try (FileOutputStream fos = new FileOutputStream(convertFile)) {
        fos.write(file.getBytes());
      }
      return Optional.of(convertFile);
    }

    return Optional.empty();
  }
}
