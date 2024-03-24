package com.yangcs.rpc.core.registry.local;

import com.yangcs.rpc.common.url.URL;
import com.yangcs.rpc.core.registry.Registry;
import com.yangcs.rpc.core.registry.RegistryFactory;

public class LocalRegistryFactory implements RegistryFactory {

    @Override
    public Registry getRegistry(URL url) {
        return new LocalRegistry();
    }
}
