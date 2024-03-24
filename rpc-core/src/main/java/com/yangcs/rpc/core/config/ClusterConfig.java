package com.yangcs.rpc.core.config;

import com.yangcs.rpc.core.annotation.Config;
import lombok.Data;

/**
 * 集群配置
 *
 */
@Data
@Config(prefix = "cluster")
public class ClusterConfig {
    /**
     * 负载均衡策略
     */
    private String loadBalance;

    /**
     * 容错策略
     */
    private String faultTolerant;

    /**
     * 重试次数，只有容错策略是 'retry' 的时候才有效
     */
    private Integer retryTimes;
}
