package com.caregiver.user.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GroupDto {

    @Getter
    @AllArgsConstructor
    public static class CreateRequest {

        @NotBlank
        private final String groupName;

        @Min(value = 3, message = "최소 3인 이상 설정 가능합니다.")
        @Max(value = 10, message = "최대 10인 까지만 설정 가능합니다.")
        private final int capacity;

        private final String description;
    }
}
