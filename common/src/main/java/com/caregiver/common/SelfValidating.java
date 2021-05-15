package com.caregiver.common;


import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**
 * Java Bean 유효성 검사를 하기 위한 클래스
 *
 * @param <T> 유효성 검사 대상 객체
 */
public abstract class SelfValidating<T extends SelfValidating<T>> {

  private final Validator validator;

  public SelfValidating() {
    validator = Validation
        .buildDefaultValidatorFactory()
        .getValidator();
  }

  /**
   * 이 인스턴스의 속성에 대한 모든 Bean 유효성 검사를 평가합니다.
   *
   * @throws ConstraintViolationException 유효성 제약을 위반한 경우
   */
  protected void validateSelf() {
    Set<ConstraintViolation<SelfValidating<T>>> violations = validator.validate(this);
    if (!violations.isEmpty()) {
      throw new ConstraintViolationException(violations);
    }
  }

}
