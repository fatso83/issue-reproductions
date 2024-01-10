package com.github.fatso83.common;

public record Bar(Foo foo) {
    public String getFooName() {
        return "foo name = " + foo.name();
    }
}
