package com.kye.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*********************************************************************************
 * <取网卡物理地址--
 * 1.在Windows,Linux系统下均可用；
 * 2.通过ipconifg,ifconfig获得计算机信息；
 * 3.再用模式匹配方式查找MAC地址，与操作系统的语言无关>
 *
 * //* Description: <取计算机名--从环境变量中取>
 * abstract 限制继承/创建实例
 */
/********************************************************************************/

public abstract class ComputerInfo {

    public static void main(String[] args) throws Exception {
        // 获取本地IP地址
        String ip = InetAddress.getLocalHost().getHostAddress();
        // 获取本地计算机名
        String name = InetAddress.getLocalHost().getHostName();
        //输出控制台
        System.out.println("IP地址："+ip);
        System.out.println("本地计算机名："+name);
    }

}
