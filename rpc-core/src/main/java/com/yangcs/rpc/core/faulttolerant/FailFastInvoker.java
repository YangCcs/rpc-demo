package com.yangcs.rpc.core.faulttolerant;

import com.yangcs.rpc.common.consts.RpcException;
import com.yangcs.rpc.core.dto.RpcRequest;
import com.yangcs.rpc.core.dto.RpcResult;
import com.yangcs.rpc.core.invoke.Invoker;
import com.yangcs.rpc.core.loadbalance.LoadBalance;

/**
 * 快速失败
 *
 * @author chenchuxin
 * @date 2021/8/8
 */
public class FailFastInvoker extends AbstractFaultTolerantInvoker {

    @Override
    protected RpcResult doInvoke(RpcRequest request, Invoker invoker, LoadBalance loadBalance) throws RpcException {
        return invoker.invoke(request);
    }
}
