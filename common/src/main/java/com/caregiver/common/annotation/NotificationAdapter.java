package com.caregiver.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;


/**
 * Notification layer 에서 사용될 Stereo Type 애노테이션.
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface NotificationAdapter {

  /**
   * Stereo Type 지정.
   */
  @AliasFor(annotation = Component.class)
  String value() default "";
}
