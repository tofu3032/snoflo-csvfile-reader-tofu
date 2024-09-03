package org.snoflo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class LibraryServiceProxy implements InvocationHandler {

    private final Object target;

    public LibraryServiceProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long beforeTime = System.currentTimeMillis();
        Object result = method.invoke(target, args);
        long afterTime = System.currentTimeMillis();
        double secDiffTime = afterTime - beforeTime / 1000.0;
        System.out.println("측정 시간 : " + secDiffTime);
        return result;
    }

    public static Object newProxyInstance(Object target) {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new LibraryServiceProxy(target));
    }

}
