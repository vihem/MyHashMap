package com.ea.jdk7;

public class Test {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("Monkey", "我是moneky老师");
        map.put("东山再起", "东山再起是位好同学");
        map.put("再起东山", "再起东山是位坏同学");
//        System.out.println(m);
//        System.out.println(d);
        System.out.println(map.get("Monkey"));
        System.out.println(map.get("东山再起"));
        System.out.println(map.get("再起东山"));
        //我是moneky老师
        //东山再起是位好同学
    }
}
