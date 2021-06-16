package com.caregiver.port.in;

import com.amazonaws.services.s3.AmazonS3Client;
import com.caregiver.common.BaseConfiguration;
import com.caregiver.config.AmazonS3Config;
import com.caregiver.user.port.in.ImageUploadUseCase.RequestCommand;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.springframework.beans.factory.annotation.Autowired;

public class UploadImageAdapterTest extends BaseConfiguration {

  @Autowired
  AmazonS3Client amazonS3Client;

  @Autowired
  AmazonS3Config amazonS3Config;

  RequestCommand requestCommand;

  @BeforeEach
  public void setUp(@TempDir File tempDir) throws IOException {
    File file = new File(tempDir, "test");
    Files.write(file.toPath(), Arrays.asList("x", "y", "z"));

    requestCommand = RequestCommand.of(file);
  }

  @Test
  @DisplayName("aws S3 이미지 업로드를 테스트하라")
  public void aws_s3_이미지_업로드를_테스트하라() {
    UploadImageAdapter uploadImageAdapter = new UploadImageAdapter(amazonS3Client, amazonS3Config);
    uploadImageAdapter.upload(requestCommand);
  }
}
