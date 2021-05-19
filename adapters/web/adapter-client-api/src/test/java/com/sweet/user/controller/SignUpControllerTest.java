package com.sweet.user.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.sweet.common.BaseControllerTest;
import com.sweet.user.port.in.SignUpUseCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

@DisplayName("SignUpController 클래스")
class SignUpControllerTest extends BaseControllerTest {

  @MockBean
  private SignUpUseCase signUpUseCase;

  @Test
  void testExample() throws Exception {
    this.mockMvc.perform(post("/v1/user/sign-up")
        .content("{\"userName\" : \"이지훈\", \"password\" : \"1234\"}")
        .contentType(APPLICATION_JSON)
        .accept(APPLICATION_JSON))
        .andExpect(status().isCreated());

  }


}
