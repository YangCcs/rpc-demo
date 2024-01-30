package com.yangcs.rpc.common.extension;


// 被此注解标记的类，表示是一个扩展接口

import com.yangcs.rpc.common.consts.URLKeyConst;

import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface SPI {

    // 默认扩展类全路径
    // @return 默认不填时default

    String value() default URLKeyConst.DEFAULT;
}
