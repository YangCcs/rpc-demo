package com.yangcs.rpc.core.compress;

import com.yangcs.rpc.common.extension.SPI;

/**
 * 压缩解压器
 *
 */
@SPI("dummy")
public interface Compressor {

    /**
     * 压缩
     *
     * @param bytes 压缩前的字节数组
     * @return 压缩后的字节数组
     */
    byte[] compress(byte[] bytes);

    /**
     * 解压
     *
     * @param bytes 解压前的字节数组
     * @return 解压后的字节数组
     */
    byte[] decompress(byte[] bytes);
}
