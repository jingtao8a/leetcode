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
        // JDK动态代理只能代理实现了接口的类或者直接代理接口
        // CGLIB动态代理可以代理未实现任何接口的类
        // CGLIB是实现一个被代理类的子类，因此不能代理声明为final类型的类和方法

        //静态代理是在编译时就生成了一个个class文件
        //动态代理是运行时动态生成类字节码，并加载到JVM中的
    }
}
