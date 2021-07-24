package com.ea.jdk7;

/**
 * �����Լ���HashMap
 * @param <K>
 * @param <V>
 */
public class HashMap<K, V> implements Map<K, V>{
    //�洢Ԫ�ض���
    private Entry<K, V>[] table = null;

    //���ݳ�ʼ��
    int size = 0;

    //��ʼ���洢Ԫ�ض����С
    public HashMap(){
        this.table = new Entry[16];
    }

    /**
     * ��������<p>
     * 1. ͨ�� ��ϣ�㷨hash(key)���� key ��ȡindex�����±�<p>
     * 2. �洢���� Entry <p>
     * 3. �жϵ�ǰ�����Ƿ�Ϊ��:
     *      ��Ϊ�գ�ֱ�Ӵ洢;
     *      ��Ϊ�գ���Ҫ�õ� next ����<p>
     * 4. ���ص�ǰ����ڵ�
     * @param k key
     * @param v value
     * @return V
     */
    @Override
    public V put(K k, V v) {
        //�� k ��ȡ �±�index
        int index = hash(k);
        //��ѯtable�������±�index��ֵ
        Entry<K, V> entry = table[index];
        if (entry == null) {
            //���table[index] Ϊ�գ��ѵ�ǰv���뵽table[index]�£���ǰ������洢��
            table[index] = new Entry<>(k, v, index, null);
            System.out.println("����ɹ������� key=" + table[index].getKey() +
                    " value=" + table[index].getValue()+
                    " next=" + table[index].next + "\n");
            size++;
        } else {
            //���table[index] ��Ϊ�գ���ʾ��Ҫ�õ�������������kv�� next ָ�� ��ǰ�Ѿ�����entry
            System.out.println("��ǰentry�Ѿ���ֵ���� key=" + entry.getKey() + " value=" + entry.getValue());
            table[index] = new Entry<>(k, v, index, entry);
            System.out.println("    ����ɹ����µ� key=" + table[index].getKey() +
                    " value=" + table[index].getValue() +
                    " nextָ�� key=" + table[index].next.getKey() +" �ĵ�ַ\n");
        }
        return table[index].getValue();
    }

    /**
     * ��key�������Ӧ��index
     *  1. ��hashCode��ȡ hashֵ
     *  2. ȡģ
     * @param k key
     * @return int index
     */
    private int hash(K k) {
        // HashMap �ײ��õ����� λ��(>>)���������ܸߺܶ�,��������ֱ��ȡģ
        int index = k.hashCode() % 16;
        // Math.abs(index)
        return index > 0 ? index : -index;
    }

    /**
     * ��ȡkey��ֵvalue
     *
     * 1. ͨ�� key ����hash���㣬ȡģ����ȡ�����Ӧ���±� index
     * 2. �ж� ��ǰ���� �Ƿ�Ϊ�գ�
     * 3. ��Ϊ�գ��ж��Ƿ����
     * 4. �ж� next �Ƿ�Ϊ�գ������Ϊ�գ����ж���ȣ�ֱ����Ȼ���Ϊ��Ϊֹ
     * 5. ���� value
     * @param k key
     * @return V
     */
    @Override
    public V get(K k) {
        //���û�д洢���ݣ���sizeΪ0������Ҫ�飬ֱ�ӷ���null
        if (size == 0){
            return null;
        }

        int index = hash(k);
        Entry<K, V> entry = findValue(table[index], k);
        //ͨ�� index �ҵ��������ֵ
        return entry==null?null:entry.getValue();
    }

    /**
     * �� entry �����л�ȡkeyΪk��ֵ
     * @param entry entry
     * @param k k
     * @return Entry
     */
    private Entry<K,V> findValue(Entry<K,V> entry, K k) {
        //��Ŀ������������ͣ�Ҳ�������ַ�������
        if (k.equals(entry.getKey()) || k == entry.getKey()){
            return entry;
        } else {
            //�������ȣ�����ڵ��Ǹ������ж���next�����Ƿ�ƥ��
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
     * �洢Ԫ�ض���:
     *      K k;
     *      V v;
     *      int hash;
     *      Entry<K, V> next;
     * @param <K> k
     * @param <V> v
     */
    static class Entry<K, V> implements Map.Entry<K,V>{
        // ��4��ֵ
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