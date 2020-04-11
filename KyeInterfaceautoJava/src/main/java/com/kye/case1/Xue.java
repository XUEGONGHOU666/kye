package com.kye.case1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Xue {
    private static Logger logger= LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    public static void main(String[] args) {
        logger.trace("log4j2日志输出：This is trace message.");
        // 记录debug级别的信息
        logger.debug("log4j2日志输出：This is debug message.");
        // 记录info级别的信息
        logger.info("log4j2日志输出：This is info message.");
        // 记录error级别的信息
        logger.error("log4j2日志输出：This is error message.");
    }
}
