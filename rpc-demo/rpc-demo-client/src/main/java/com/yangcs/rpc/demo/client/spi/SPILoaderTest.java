package com.yangcs.rpc.demo.client.spi;

import com.yangcs.rpc.common.extension.ExtensionLoader;

import java.util.Iterator;
import java.util.ServiceLoader;

public class SPILoaderTest {
    public static void main(String[] args) {

        ServiceLoader<Serializer> serviceLoader = ServiceLoader.load(Serializer.class);
        Iterator<Serializer> iterator = serviceLoader.iterator();
        while (iterator.hasNext()) {
            Serializer serializer = iterator.next();
            System.out.println(serializer.getClass().getName());
        }
    }

    public static void main2(String[] args) {
        ExtensionLoader<Serializer> loader = ExtensionLoader.getLoader(Serializer.class);
        Serializer serializer = loader.getExtension("protostuff");
        System.out.println(serializer.getClass().getName());
    }
}
