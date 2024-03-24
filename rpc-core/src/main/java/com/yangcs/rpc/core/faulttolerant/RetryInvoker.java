package com.yangcs.rpc.core.faulttolerant;

import com.yangcs.rpc.common.consts.RpcException;
import com.yangcs.rpc.core.dto.RpcRequest;
import com.yangcs.rpc.core.dto.RpcResult;
import com.yangcs.rpc.core.invoke.Invoker;
import com.yangcs.rpc.core.loadbalance.LoadBalance;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

/**
 * 重试执行，只有幂等的才能重试
 *
 */
@Slf4j
public class RetryInvoker extends AbstractFaultTolerantInvoker {

    /**
     * 默认重试次数
     */
    private static final Integer DEFAULT_RETRY_TIMES = 3;

    @Override
    protected RpcResult doInvoke(RpcRequest request, Invoker invoker, LoadBalance loadBalance) throws RpcException {
        int retryTimes = Optional.ofNullable(clusterConfig.getRetryTimes()).orElse(DEFAULT_RETRY_TIMES);
        RpcException rpcException = null;
        for (int i = 0; i < retryTimes; i++) {
            try {
                RpcResult result = invoker.invoke(request);
                if (result.isSuccess()) {
                    return result;
                }
            } catch (RpcException ex) {
                log.error("invoke error. retry times=" + i, ex);
                rpcException = ex;
            }
        }
        if (rpcException == null) {
            rpcException = new RpcException("invoker error. request=" + request);
        }
        throw rpcException;
    }
}
