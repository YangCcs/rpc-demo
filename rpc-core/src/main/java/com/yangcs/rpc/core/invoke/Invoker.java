package com.yangcs.rpc.core.invoke;

import com.yangcs.rpc.common.consts.RpcException;
import com.yangcs.rpc.common.extension.SPI;
import com.yangcs.rpc.core.dto.RpcRequest;
import com.yangcs.rpc.core.dto.RpcResult;

/**
 * 执行者
 */
@SPI("netty")
public interface Invoker {

    /**
     * 执行
     *
     * @param request 请求
     * @return result
     * @throws RpcException 执行异常会抛出
     */
    RpcResult invoke(RpcRequest request) throws RpcException;
}
