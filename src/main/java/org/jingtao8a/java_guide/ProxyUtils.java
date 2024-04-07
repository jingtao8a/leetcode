package org.jingtao8a.java_guide;

public class ProxyUtils {
    public static void staticProxyTest() {
        SmsServiceImpl smsService = new SmsServiceImpl();
        SmsProxy proxy = new SmsProxy(smsService);
        smsService.send("hello");
        proxy.send("hello");
    }

    public static void JDKProxyTest() {//不用实现SmsProxy
        SmsServiceImpl smsService = new SmsServiceImpl();
        SmsService proxy = (SmsService)JdkProxyFactory.getProxy(smsService);
        proxy.send("hello");
    }

    public static void CGLIBProxyTest() {
        SmsServiceImpl proxy = (SmsServiceImpl) CglibProxyFactory.getProxy(SmsServiceImpl.class);
        proxy.send("hello");
    }
}
