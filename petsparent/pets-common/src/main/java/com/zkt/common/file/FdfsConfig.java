package com.zkt.common.file;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 接下来需要初始化fastdfs的相关配置，以便初始化的时候做全局加载，使配置生效，这里创建了两个类，
 * FdfsConfig，FdfsConfiguration，
 * FdfsConfig主要用以连接fastdfs，FdfsConfiguration使配置生效，
 */

@Component
public class FdfsConfig {

    @Value("${fdfs.resHost}")
    private String resHost;

    @Value("${fdfs.storagePort}")
    private String storagePort;

    public String getResHost() {
        return resHost;
    }

    public void setResHost(String resHost) {
        this.resHost = resHost;
    }

    public String getStoragePort() {
        return storagePort;
    }

    public void setStoragePort(String storagePort) {
        this.storagePort = storagePort;
    }

}
