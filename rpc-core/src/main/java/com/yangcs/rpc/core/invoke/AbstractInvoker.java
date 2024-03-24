package com.yangcs.rpc.core.invoke;

import cn.hutool.core.collection.CollectionUtil;
import com.yangcs.rpc.common.consts.RpcException;
import com.yangcs.rpc.common.consts.URLKeyConst;
import com.yangcs.rpc.common.extension.ExtensionLoader;
import com.yangcs.rpc.common.url.URL;
import com.yangcs.rpc.common.url.URLBuilder;
import com.yangcs.rpc.core.config.ConfigManager;
import com.yangcs.rpc.core.dto.RpcRequest;
import com.yangcs.rpc.core.dto.RpcResult;
import com.yangcs.rpc.core.loadbalance.LoadBalance;
import com.yangcs.rpc.core.registry.Registry;
import com.yangcs.rpc.core.registry.RegistryFactory;

import java.util.List;
import java.util.Map;

/**
 * 抽象执行者
 */
public abstract class AbstractInvoker implements Invoker {

    private final RegistryFactory registryFactory = ExtensionLoader.getLoader(RegistryFactory.class).getAdaptiveExtension();
    private final Registry registry = registryFactory.getRegistry(ConfigManager.getInstant().getRegistryConfig().toURL());
    private final LoadBalance loadBalance = ExtensionLoader.getLoader(LoadBalance.class)
            .getExtension(ConfigManager.getInstant().getClusterConfig().getLoadBalance());

    @Override
    public RpcResult invoke(RpcRequest request) throws RpcException {
        Map<String, String> serviceParam = URLBuilder.getServiceParam(request.getInterfaceName(), request.getVersion());
        URL url = URL.builder().protocol(URLKeyConst.RPC_PROTOCOL).host(URLKeyConst.ANY_HOST).params(serviceParam).build();
        // 注册中心拿出所有服务的信息
        List<URL> urls = registry.lookup(url);
        if (CollectionUtil.isEmpty(urls)) {
            throw new RpcException("Not service Providers registered." + serviceParam);
        }
        URL selected = loadBalance.select(urls, request);
        return doInvoke(request, selected);
    }

    protected abstract RpcResult doInvoke(RpcRequest rpcRequest, URL selected) throws RpcException;
}
