package com.ea.jdk7;

/**
 * 定义自己的Map
 * @param <K> k
 * @param <V> v
 */
public interface Map<K, V> {
    /**
     * 插入数据
     * @param k key
     * @param v value
     * @return V
     */
    V put(K k,V v);

    /**
     * 获取key的值
     * @param k key
     * @return V
     */
    V get(K k);

    /**
     * 获取长度
     * @return int
     */
    int size();

    /**
     * 存储元素对象
     * @param <K> k
     * @param <V> v
     */
    interface Entry<K, V>{
        K getKey();
        V getValue();
    }
}
