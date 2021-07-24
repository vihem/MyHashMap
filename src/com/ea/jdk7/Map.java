package com.ea.jdk7;

/**
 * �����Լ���Map
 * @param <K> k
 * @param <V> v
 */
public interface Map<K, V> {
    /**
     * ��������
     * @param k key
     * @param v value
     * @return V
     */
    V put(K k,V v);

    /**
     * ��ȡkey��ֵ
     * @param k key
     * @return V
     */
    V get(K k);

    /**
     * ��ȡ����
     * @return int
     */
    int size();

    /**
     * �洢Ԫ�ض���
     * @param <K> k
     * @param <V> v
     */
    interface Entry<K, V>{
        K getKey();
        V getValue();
    }
}
