package com.yangcs.rpc.core.faulttolerant;

import com.yangcs.rpc.common.consts.RpcException;
import com.yangcs.rpc.common.extension.ExtensionLoader;
import com.yangcs.rpc.core.config.ClusterConfig;
import com.yangcs.rpc.core.config.ConfigManager;
import com.yangcs.rpc.core.dto.RpcRequest;
import com.yangcs.rpc.core.dto.RpcResult;
import com.yangcs.rpc.core.invoke.Invoker;
import com.yangcs.rpc.core.loadbalance.LoadBalance;

/**
 * 容错执行者
 *
 * @author chenchuxin
 * @date 2021/8/8
 */
public abstract class AbstractFaultTolerantInvoker implements FaultTolerantInvoker {

    protected final ClusterConfig clusterConfig = ConfigManager.getInstant().getClusterConfig();

    private final LoadBalance loadBalance = ExtensionLoader.getLoader(LoadBalance.class)
            .getExtension(ConfigManager.getInstant().getClusterConfig().getLoadBalance());
    private final Invoker invoker = ExtensionLoader.getLoader(Invoker.class).getDefaultExtension();

    @Override
    public RpcResult invoke(RpcRequest request) throws RpcException {
        return doInvoke(request, invoker, loadBalance);
    }

    /**
     * 执行
     *
     * @param request       请求
     * @param invoker       具体执行者
     * @param loadBalance   负载
     * @return 结果
     * @throws RpcException 请求失败会抛出异常
     */
    protected abstract RpcResult doInvoke(RpcRequest request, Invoker invoker, LoadBalance loadBalance) throws RpcException;
}
