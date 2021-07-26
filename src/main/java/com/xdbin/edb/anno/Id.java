package com.xdbin.edb.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author BaoXuebin
 * @since 2021/7/26
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.SOURCE)
public @interface Id {
}
