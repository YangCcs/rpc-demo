package com.yangcs.rpc.core.loadbalance;

import com.yangcs.rpc.common.extension.SPI;
import com.yangcs.rpc.common.url.URL;
import com.yangcs.rpc.core.dto.RpcRequest;

import java.util.List;

/**
 * 负载均衡
 */
@SPI("round-robin")
public interface LoadBalance {

    /**
     * 选择
     *
     * @param candidateUrls 候选的 URL
     * @param request       请求
     * @return 选择的 URL
     */
    URL select(List<URL> candidateUrls, RpcRequest request);
}
