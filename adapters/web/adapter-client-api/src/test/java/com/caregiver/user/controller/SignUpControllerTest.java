package com.caregiver.user.controller;

import static com.caregiver.common.ApiDocumentUtils.getDocumentRequest;
import static com.caregiver.common.ApiDocumentUtils.getDocumentResponse;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.JsonFieldType.BOOLEAN;
import static org.springframework.restdocs.payload.JsonFieldType.OBJECT;
import static org.springframework.restdocs.payload.JsonFieldType.STRING;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.caregiver.common.BaseControllerTest;
import com.caregiver.user.port.in.SignUpUseCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.test.web.servlet.ResultActions;

@WebMvcTest(SignUpController.class)
@DisplayName("SignUpController 클래스는")
class SignUpControllerTest extends BaseControllerTest {

  private static final String URL = "/v1/user/sign-up";

  @MockBean
  private SignUpUseCase signUpUseCase;

  @Test
  void testExample() throws Exception {

    ResultActions resultActions = mockMvc.perform(RestDocumentationRequestBuilders.post(URL)
        .content("{\"userName\" : \"이지훈\", \"password\" : \"1234\"}")
        .contentType(MediaType.APPLICATION_JSON)
    );

    resultActions.andExpect(status().isCreated())
        .andDo(document("sticker/make-sticker",
            getDocumentRequest(),
            getDocumentResponse(),
            requestFields(
                fieldWithPath("userName").description("유저 이름").type(STRING),
                fieldWithPath("password").description("패스워드").type(STRING)
            ),
            responseFields(
                fieldWithPath("success").description("성공 여부").type(BOOLEAN),
                fieldWithPath("message").description("응답 메세지").type(STRING),
                fieldWithPath("data").description("응답 데이터").type(OBJECT).optional()
            )
        ));

  }

}
