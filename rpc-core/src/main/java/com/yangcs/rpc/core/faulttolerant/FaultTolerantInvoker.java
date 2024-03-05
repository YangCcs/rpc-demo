package com.yangcs.rpc.core.faulttolerant;

import com.yangcs.rpc.common.extension.SPI;
import com.yangcs.rpc.core.invoke.Invoker;

/**
 * 容错
 *
 * @author chenchuxin
 * @date 2021/8/8
 */
@SPI("fail-fast")
public interface FaultTolerantInvoker extends Invoker {
}
