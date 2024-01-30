package com.yangcs.rpc.common.extension;

/*
* 和@SPI联合使用，在方法上面标记
* 使用的方法中必须要有URL参数
* 代理生成的扩展类会自动读取URL参数上的@link Adaptive#value（）参数，再根据这个参数类型，获取对应的扩展类
* */

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Adaptive {
    String value() default "";
}
