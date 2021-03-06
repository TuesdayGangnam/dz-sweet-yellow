package com.caregiver.port.in;

import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.caregiver.common.annotation.PersistenceAdapter;
import com.caregiver.config.AmazonS3Properties;
import com.caregiver.config.AwsS3Client;
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

  private final AmazonS3Properties amazonS3Properties;
  private final AwsS3Client amazonS3Client;

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
        amazonS3Properties.getImagePath() + uploadFile.getName(),
        amazonS3Properties.getBucket()
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
    amazonS3Client.s3Client().putObject(
        new PutObjectRequest(bucket, fileName, uploadFile)
            .withCannedAcl(CannedAccessControlList.PublicRead)
    );

    return amazonS3Client.s3Client().getUrl(bucket, fileName).toString();
  }

  /**
   * 파일을 삭제 합니다.
   * 파일이 삭제 여부에 따라 log 를 출력합니다.
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
