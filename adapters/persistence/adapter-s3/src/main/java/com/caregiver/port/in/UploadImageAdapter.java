package com.caregiver.port.in;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.caregiver.config.AmazonS3Config;
import com.caregiver.user.port.in.ImageUploadUseCase.RequestCommand;
import com.caregiver.user.port.in.ImageUploadUseCase.ResponseCommand;
import com.caregiver.user.port.out.ImageUploadPort;
import java.io.File;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class UploadImageAdapter implements ImageUploadPort {

  private final AmazonS3Client amazonS3Client;
  private final AmazonS3Config amazonS3Config;

  @Override
  public ResponseCommand upload(RequestCommand command) {
    File uploadFile = command.getUploadFile();
    String uploadImageUrl = putS3(
        uploadFile,
        amazonS3Config.getImagePath() + uploadFile.getName(),
        amazonS3Config.getBucket()
    );
    removeNewFile(uploadFile);

    return ResponseCommand.of(uploadImageUrl);
  }

  private String putS3(File uploadFile, String fileName, String bucket) {
    amazonS3Client.putObject(
        new PutObjectRequest(bucket, fileName, uploadFile)
            .withCannedAcl(CannedAccessControlList.PublicRead)
    );

    return amazonS3Client.getUrl(bucket, fileName).toString();
  }

  private void removeNewFile(File targetFile) {
    if (targetFile.delete()) {
      log.info("파일이 삭제되었습니다.");
    } else {
      log.info("파일이 삭제되지 못했습니다.");
    }
  }
}
