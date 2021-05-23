package com.caregiver.user.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GroupDto {

  @Getter
  @NoArgsConstructor
  public static class CreateRequest {

    @NotBlank
    private String groupName;

    @Min(3)
    @Max(10)
    private int numberOfParticipants;

    private String description;

    public CreateRequest(String groupName, int numberOfParticipants, String description) {
      this.groupName = groupName;
      this.numberOfParticipants = numberOfParticipants;
      this.description = description;
    }
  }
}
