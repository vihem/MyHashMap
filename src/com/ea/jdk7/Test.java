package com.ea.jdk7;

public class Test {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("Monkey", "����moneky��ʦ");
        map.put("��ɽ����", "��ɽ������λ��ͬѧ");
        map.put("����ɽ", "����ɽ��λ��ͬѧ");
//        System.out.println(m);
//        System.out.println(d);
        System.out.println(map.get("Monkey"));
        System.out.println(map.get("��ɽ����"));
        System.out.println(map.get("����ɽ"));
        //����moneky��ʦ
        //��ɽ������λ��ͬѧ
    }
}
