package com.caregiver.user.controller;

import static com.caregiver.common.ApiDocumentUtils.getDocumentRequest;
import static com.caregiver.common.ApiDocumentUtils.getDocumentResponse;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.payload.JsonFieldType.STRING;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.caregiver.common.BaseControllerTest;
import com.caregiver.user.port.in.SendAccreditationNumberUsecase;
import com.caregiver.utils.ResourceMockUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;

@WebMvcTest(MobileAuthenticationController.class)
@DisplayName("MobileAuthenticationController 클래스")
class MobileAuthenticationControllerDocumentTest extends BaseControllerTest {

  private static final String URL = "/v1/mobile/accreditation-number/accept-sms";
  private static final String SUCCESS_JSON = "/유저/인증번호_요청/정상_휴대폰번호.json";

  @MockBean
  private SendAccreditationNumberUsecase sendAccreditationNumberUsecase;

  @DisplayName("[성공] 인증번호 요청")
  @Test
  void test1() throws Exception {

    ResultActions resultActions = mockMvc.perform(post(URL)
        .content(ResourceMockUtil.getString(SUCCESS_JSON))
        .contentType(MediaType.APPLICATION_JSON)
    );

    resultActions.andExpect(status().isCreated())
        .andDo(document("user/accreditation-number/accept-sms",
            getDocumentRequest(),
            getDocumentResponse(),
            requestFields(
                fieldWithPath("mobile")
                    .description("인증번호를 받을 휴대폰 번호")
                    .type(STRING)
            )));
  }


}
