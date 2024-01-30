package com.yangcs.rpc.demo.client.spi;

import cn.hutool.json.JSONUtil;

public class JSONSerializer implements Serializer{
    @Override
    public byte[] serialize(Object object) {
        return JSONUtil.toJsonStr(object).getBytes();
    }
}
