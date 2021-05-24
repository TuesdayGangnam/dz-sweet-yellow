package com.caregiver.user.dto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("GroupDto 클래스의")
class GroupDtoTest {

    private static Validator validator;

    @BeforeAll
    static void init() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @Nested
    @DisplayName("GroupDto.CreateRequest 메소드는 ")
    class Describe_01 {

        @Nested
        @DisplayName("3 이하의 capacity 로 호출 되었을 경우")
        class Context_01 {

            GroupDto.CreateRequest createRequest =
                    new GroupDto.CreateRequest("그룹", 1, "");

            @Test
            @DisplayName("최소 3인 이상 설정 가능합니다. 라는 에러 메시지를 반환한다.")
            public void it_01() {
                Set<ConstraintViolation<GroupDto.CreateRequest>> constraintViolations =
                        validator.validate(createRequest);

                assertEquals(1, constraintViolations.size());
                assertEquals("최소 3인 이상 설정 가능합니다.", constraintViolations
                        .iterator().next().getMessage());
            }
        }

        @Nested
        @DisplayName("10 이상의 capacity 로 호출 되었을 경우")
        class Context_02 {

            GroupDto.CreateRequest createRequest =
                    new GroupDto.CreateRequest("그룹", 11, "");

            @Test
            @DisplayName("최소 3인 이상 설정 가능합니다. 라는 에러 메시지를 반환한다.")
            public void it_02() {
                Set<ConstraintViolation<GroupDto.CreateRequest>> constraintViolations =
                        validator.validate(createRequest);

                assertEquals(1, constraintViolations.size());
                assertEquals("최대 10인 이상만 설정 가능합니다.", constraintViolations
                        .iterator().next().getMessage());
            }
        }
    }
}
