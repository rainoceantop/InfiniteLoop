package com.InfiniteLoop.test;

import java.lang.reflect.Field;

public class Main {
    private String name = "hello";
    public long number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) throws Exception {
        Main pt = new Main();

        Class<Main> clazz = Main.class;

        Field field = clazz.getDeclaredField("name");
        field.setAccessible(true);
        field.set(pt, "world");
        field.setAccessible(false);

        Field fieldNum = clazz.getDeclaredField("number");
        fieldNum.setAccessible(true);
        fieldNum.set(pt, 20);
        fieldNum.setAccessible(false);

        System.out.println(pt.getName());
        System.out.println(pt.number);
    }
}