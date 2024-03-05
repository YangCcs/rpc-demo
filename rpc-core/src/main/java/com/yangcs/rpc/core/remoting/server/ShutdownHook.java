package com.yangcs.rpc.core.remoting.server;

import com.yangcs.rpc.common.extension.ExtensionLoader;
import com.yangcs.rpc.core.config.ConfigManager;
import com.yangcs.rpc.core.config.RegistryConfig;
import com.yangcs.rpc.core.registry.Registry;
import com.yangcs.rpc.core.registry.RegistryFactory;
import lombok.extern.slf4j.Slf4j;

/**
 * 关闭的钩子
 *
 * @author chenchuxin
 * @date 2021/7/24
 */
@Slf4j
public class ShutdownHook {

    public static void addShutdownHook() {
        log.info("addShutdownHook for clearAll");
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            RegistryFactory registryFactory = ExtensionLoader.getLoader(RegistryFactory.class).getAdaptiveExtension();
            RegistryConfig registryConfig = ConfigManager.getInstant().getRegistryConfig();
            Registry registry = registryFactory.getRegistry(registryConfig.toURL());
            registry.unregisterAllMyService();
        }));
    }
}
