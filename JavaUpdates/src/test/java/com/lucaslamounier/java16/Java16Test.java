package com.lucaslamounier.java16;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Java16Test {

    @Test
    void testProxy() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Object proxy = Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class<?>[]{HelloWorld.class},
                (proxxy, method, args) -> {
                    if (method.isDefault()) {
                        return InvocationHandler.invokeDefault(proxxy, method, args);
                    }
                    // ...
                    return proxxy;
                }
        );

        Method method = proxy.getClass().getMethod("hello");

        assertThat(method.invoke(proxy)).isEqualTo("Hello World");
    }

    @Test
    void dayPeriodSupport() {
        LocalTime date = LocalTime.parse("15:25:08.690791");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h B", Locale.US);
        assertThat(date.format(formatter)).isEqualTo("3 in the afternoon");

        formatter = DateTimeFormatter.ofPattern("h B", Locale.of("pt"));
        assertThat(date.format(formatter)).isEqualTo("3 da tarde");
    }
}
