package com.yangcs.rpc.core.config;

import com.yangcs.rpc.core.annotation.Config;
import lombok.Data;

/**
 * 服务启动配置
 *
 */
@Data
@Config(prefix = "service")
public class ServiceConfig {
    /**
     * 默认服务端口
     */
    private static final Integer DEFAULT_SERVICE_PORT = 5525;

    /**
     * 监听的端口
     */
    private Integer port;

    public Integer getPort() {
        return (port != null && port > 0) ? port : DEFAULT_SERVICE_PORT;
    }
}
