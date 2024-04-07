package org.jingtao8a.java_guide;

public class test1 {
    public static void main(String[] args) {
        // 静态代理
        ProxyUtils.staticProxyTest();
        //动态代理
        //JDK动态代理
        ProxyUtils.JDKProxyTest();
        //CGLIB动态代理
        ProxyUtils.CGLIBProxyTest();
    }
}
