package com.yangcs.rpc.demo.service;

import com.yangcs.rpc.core.annotation.RpcScan;
import com.yangcs.rpc.core.remoting.server.netty.NettyServerBootstrap;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 启动类
 */
@SpringBootApplication
@RpcScan(basePackages = {"com.ccx.rpc.demo.service"})
public class ServiceBootstrap {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ServiceBootstrap.class);
        NettyServerBootstrap serverBootstrap = (NettyServerBootstrap) applicationContext.getBean("nettyServerBootstrap");
        serverBootstrap.start();
    }

}
