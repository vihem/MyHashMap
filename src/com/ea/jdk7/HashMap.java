package com.ea.jdk7;

/**
 * 定义自己的HashMap
 * @param <K>
 * @param <V>
 */
public class HashMap<K, V> implements Map<K, V>{
    //存储元素对象
    private Entry<K, V>[] table = null;

    //扩容初始化
    int size = 0;

    //初始化存储元素对象大小
    public HashMap(){
        this.table = new Entry[16];
    }

    /**
     * 插入数据<p>
     * 1. 通过 哈希算法hash(key)，用 key 获取index数组下标<p>
     * 2. 存储对象 Entry <p>
     * 3. 判断当前对象是否为空:
     *      若为空，直接存储;
     *      不为空，就要用到 next 链表<p>
     * 4. 返回当前这个节点
     * @param k key
     * @param v value
     * @return V
     */
    @Override
    public V put(K k, V v) {
        //用 k 获取 下标index
        int index = hash(k);
        //查询table数组在下标index的值
        Entry<K, V> entry = table[index];
        if (entry == null) {
            //如果table[index] 为空，把当前v存入到table[index]下（当前是数组存储）
            table[index] = new Entry<>(k, v, index, null);
            System.out.println("保存成功，现在 key=" + table[index].getKey() +
                    " value=" + table[index].getValue()+
                    " next=" + table[index].next + "\n");
            size++;
        } else {
            //如果table[index] 不为空，表示需要用到链表，把新增的kv的 next 指向 当前已经存在entry
            System.out.println("当前entry已经有值：其 key=" + entry.getKey() + " value=" + entry.getValue());
            table[index] = new Entry<>(k, v, index, entry);
            System.out.println("    保存成功，新的 key=" + table[index].getKey() +
                    " value=" + table[index].getValue() +
                    " next指向 key=" + table[index].next.getKey() +" 的地址\n");
        }
        return table[index].getValue();
    }

    /**
     * 用key计算出对应的index
     *  1. 用hashCode获取 hash值
     *  2. 取模
     * @param k key
     * @return int index
     */
    private int hash(K k) {
        // HashMap 底层用到的是 位移(>>)操作，性能高很多,我们这里直接取模
        int index = k.hashCode() % 16;
        // Math.abs(index)
        return index > 0 ? index : -index;
    }

    /**
     * 获取key的值value
     *
     * 1. 通过 key 进行hash运算，取模，获取数组对应的下标 index
     * 2. 判断 当前对象 是否为空，
     * 3. 不为空，判断是否相等
     * 4. 判断 next 是否为空，如果不为空，再判断相等，直到相等或者为空为止
     * 5. 返回 value
     * @param k key
     * @return V
     */
    @Override
    public V get(K k) {
        //如果没有存储数据，那size为0，不需要查，直接返回null
        if (size == 0){
            return null;
        }

        int index = hash(k);
        Entry<K, V> entry = findValue(table[index], k);
        //通过 index 找到这个对象值
        return entry==null?null:entry.getValue();
    }

    /**
     * 从 entry 数组中获取key为k的值
     * @param entry entry
     * @param k k
     * @return Entry
     */
    private Entry<K,V> findValue(Entry<K,V> entry, K k) {
        //存的可能是数据类型，也可能是字符串类型
        if (k.equals(entry.getKey()) || k == entry.getKey()){
            return entry;
        } else {
            //如果不相等，这个节点是个链表，判断它next数据是否匹配
            if (entry.next != null){
                return findValue(entry.next, k);
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size++;
    }

    /**
     * 存储元素对象:
     *      K k;
     *      V v;
     *      int hash;
     *      Entry<K, V> next;
     * @param <K> k
     * @param <V> v
     */
    static class Entry<K, V> implements Map.Entry<K,V>{
        // 存4个值
        K k;
        V v;
        int hash;
        Entry<K, V> next;

        public Entry(K k, V v, int hash, Entry<K, V> next) {
            this.k = k;
            this.v = v;
            this.hash = hash;
            this.next = next;
        }

        @Override
        public K getKey() {
            return k;
        }

        @Override
        public V getValue() {
            return v;
        }
    }
}