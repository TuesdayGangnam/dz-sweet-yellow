package com.caregiver.port.in;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.caregiver.common.BaseConfiguration;
import com.caregiver.config.AmazonS3Properties;
import com.caregiver.config.AwsS3Client;
import com.caregiver.user.port.in.ImageUploadUseCase.RequestCommand;
import com.caregiver.user.port.in.ImageUploadUseCase.ResponseCommand;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * UploadImageAdapter 를 테스트 합니다.
 */
@SuppressWarnings({"NonAsciiCharacters", "CheckStyle"})
public class UploadImageAdapterTest extends BaseConfiguration {

  @Autowired
  AmazonS3Properties amazonS3Properties;

  @Autowired
  AwsS3Client amazonS3Client;

  RequestCommand requestCommand;

  @BeforeEach
  public void setUp(@TempDir File tempDir) throws IOException {
    File file = new File(tempDir, "test");
    Files.write(file.toPath(), List.of("x", "y", "z"));

    requestCommand = RequestCommand.of(file);
  }

  @Test
  @DisplayName("aws S3 이미지 업로드를 테스트하라")
  public void aws_s3_이미지_업로드를_테스트하라() {
    UploadImageAdapter uploadImageAdapter = new UploadImageAdapter(amazonS3Properties, amazonS3Client);
    ResponseCommand upload = uploadImageAdapter.upload(requestCommand);

    assertThat(upload.getUploadImageUrl()).isNotBlank();
  }
}
