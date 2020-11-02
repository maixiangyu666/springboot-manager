package com.kc.project.common.aop.annotation;

import java.lang.annotation.*;

/**
 * LogAnnotation
 *
 * @date 2020年6月12日
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogAnnotation {
    /** 模块 */
    String title() default "";

    /** 功能 */
    String action() default "";
}
