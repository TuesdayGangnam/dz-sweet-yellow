package com.caregiver.port.in;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.caregiver.common.annotation.PersistenceAdapter;
import com.caregiver.config.AmazonS3Config;
import com.caregiver.user.port.in.ImageUploadUseCase.RequestCommand;
import com.caregiver.user.port.in.ImageUploadUseCase.ResponseCommand;
import com.caregiver.user.port.out.ImageUploadPort;
import java.io.File;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 이미지 업로드 어뎁터.
 */
@Slf4j
@PersistenceAdapter
@RequiredArgsConstructor
public class UploadImageAdapter implements ImageUploadPort {

  private final AmazonS3Client amazonS3Client;
  private final AmazonS3Config amazonS3Config;

  /**
   * 파일을 업로드 합니다.
   *
   * @param command 파일을 업로드 하기 위한 커멘드
   */
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

  /**
   * 파일을 S3 에 업로드 합니다.
   *
   * @param uploadFile 업로드할 파일 객체
   * @param fileName   업로드할 파일명
   * @param bucket     업로드한 버킷
   * @return 업로드한 파일의 경로
   */
  private String putS3(File uploadFile, String fileName, String bucket) {
    amazonS3Client.putObject(
        new PutObjectRequest(bucket, fileName, uploadFile)
            .withCannedAcl(CannedAccessControlList.PublicRead)
    );

    return amazonS3Client.getUrl(bucket, fileName).toString();
  }

  /**
   * 파일을 삭제 합니다.
   *
   * @param targetFile 삭제할 파일
   */
  private void removeNewFile(File targetFile) {
    if (targetFile.delete()) {
      log.info("파일이 삭제되었습니다.");
    } else {
      log.info("파일이 삭제되지 못했습니다.");
    }
  }
}
