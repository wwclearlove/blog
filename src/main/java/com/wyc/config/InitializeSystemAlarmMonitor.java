/**
 * <p>Title: InitializeSystemUser.java</p>
 * <p>Description: 系统启动自动处理用户信息</p>
 * <p>Copyright: Copyright (c) 2019</p>
 * <p>Company: 深圳市中钞信达成都研发中心</p>
 *
 * @author noel
 * @date 2019年9月4日
 */
package com.wyc.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;

/**
 * 初始化    司机异常行为报警可配置监测参数：
 *
 * @author noel
 * @date 2019年9月4日
 */
@Component
public class InitializeSystemAlarmMonitor {
    private static final Logger log = LoggerFactory.getLogger(InitializeSystemAlarmMonitor.class);

    /**
     * 根据配置自动加载监测参数
     */
    @Value("${path.file-upload-path}")
    private String fileUplaodPath;
    @Value("${path.monitor-config-location}")
    private String monitorpath;
    private final String UPDATEFILENAME = "monitor-config.json";

    @PostConstruct
    public void setAlarmMonitor() throws IOException {
        System.out.println("------1");
//		先判断是否有新的配置文件，如果没有再读取默认配置文件
        ClassPathResource resource = new ClassPathResource(UPDATEFILENAME);

        File file = new File(fileUplaodPath + monitorpath, UPDATEFILENAME);
        System.out.println("------2");
        if (!file.getParentFile().exists()) {
            System.out.println("------3");
            file.getParentFile().mkdirs();
            FileCopyUtils.copy(resource.getFile(), file);
        }
    }
}
