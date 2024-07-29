package com.lucaslamounier.java16;

public interface HelloWorld {
    default String hello() {
        return "Hello World";
    }
}
