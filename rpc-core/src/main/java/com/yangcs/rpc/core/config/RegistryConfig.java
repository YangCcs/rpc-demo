package com.yangcs.rpc.core.config;

import com.yangcs.rpc.common.url.URL;
import com.yangcs.rpc.core.annotation.Config;
import lombok.Data;

/**
 * 注册中心配置
 *
 */
@Data
@Config(prefix = "registry")
public class RegistryConfig {

    /**
     * 注册中心地址。zk://10.20.153.10:6379?backup=10.20.153.11:6379,10.20.153.12:6379
     */
    private String address;

    public URL toURL() {
        return URL.valueOf(address);
    }
}
