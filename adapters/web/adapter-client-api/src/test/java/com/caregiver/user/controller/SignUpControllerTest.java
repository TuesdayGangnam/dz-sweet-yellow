package com.caregiver.user.controller;

import com.caregiver.common.BaseControllerTest;
import com.caregiver.user.port.in.SignUpUseCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SignUpController.class)
@DisplayName("SignUpController 클래스는")
class SignUpControllerTest extends BaseControllerTest {

  private static final String URL = "/v1/user/sign-up";

  @MockBean
  private SignUpUseCase signUpUseCase;

  @Test
  void testExample() throws Exception {
    this.mockMvc.perform(post(URL)
        .content("{\"userName\" : \"이지훈\", \"password\" : \"1234\"}")
        .contentType(APPLICATION_JSON)
        .accept(APPLICATION_JSON))
        .andExpect(status().isCreated());
  }


}
