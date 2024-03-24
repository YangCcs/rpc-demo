package com.yangcs.rpc.demo.service.api.impl;

import com.yangcs.rpc.core.annotation.RpcService;
import com.yangcs.rpc.demo.service.api.UserService;
import com.yangcs.rpc.demo.service.bean.UserInfo;

/**
 * 用户服务
 */
@RpcService
public class UserServiceImpl implements UserService {

    @Override
    public UserInfo getUser(Long id) {
        return UserInfo.builder().userId(id).userName("user" + id).build();
    }
}
