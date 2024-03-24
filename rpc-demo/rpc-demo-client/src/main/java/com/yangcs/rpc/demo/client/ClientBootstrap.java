package com.yangcs.rpc.demo.client;

import com.yangcs.rpc.core.annotation.RpcScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RpcScan(basePackages = {"com.yangcs.rpc.demo.client"})
public class ClientBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(ClientBootstrap.class, args);
    }
}
