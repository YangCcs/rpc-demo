package com.yangcs.rpc.demo.client.spi;

public interface Serializer {
    byte[] serialize(Object object);
}
