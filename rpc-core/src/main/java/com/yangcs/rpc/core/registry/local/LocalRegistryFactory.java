package com.yangcs.rpc.core.registry.local;

import com.yangcs.rpc.common.url.URL;
import com.yangcs.rpc.core.registry.Registry;
import com.yangcs.rpc.core.registry.RegistryFactory;

/**
 * @author chenchuxin
 * @date 2021/7/18
 */
public class LocalRegistryFactory implements RegistryFactory {

    @Override
    public Registry getRegistry(URL url) {
        return new LocalRegistry();
    }
}
