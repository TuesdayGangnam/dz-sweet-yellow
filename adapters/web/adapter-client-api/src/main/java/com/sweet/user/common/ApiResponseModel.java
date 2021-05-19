package com.sweet.user.common;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class ApiResponseModel<E> {

  private boolean success;
  private String message;
  private E data;

  @Builder
  public ApiResponseModel(final boolean success, final String message, final E data) {
    this.success = success;
    this.message = message;
    this.data = data;
  }

}
