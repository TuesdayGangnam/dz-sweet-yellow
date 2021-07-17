package com.caregiver.common;

import static org.springframework.restdocs.operation.preprocess.Preprocessors.modifyUris;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessRequest;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;

import org.springframework.restdocs.operation.preprocess.OperationRequestPreprocessor;
import org.springframework.restdocs.operation.preprocess.OperationResponsePreprocessor;

/**
 * Spring REST Docs util.
 */
public class ApiDocumentUtils {

  /**
   * REST Docs 요청 포멧을 보기 좋게 변환합니다.
   */
  public static OperationRequestPreprocessor getDocumentRequest() {
    return preprocessRequest(
        modifyUris()
            .scheme("http")
            .host("13.209.80.116")
            .port(8080),
        prettyPrint());
  }

  /**
   * REST Docs 응답 포멧을 보기 좋게 변환합니다.
   */
  public static OperationResponsePreprocessor getDocumentResponse() {
    return preprocessResponse(prettyPrint());
  }
}
