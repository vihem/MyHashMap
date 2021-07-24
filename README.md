# MyHashMap

#面试被问到HashMap 底层原理?看完这边文章绝对不慌！
	
https://blog.csdn.net/weixin_39436556/article/details/118635569

## HashMap 其实就是做存储的，做存储的就是数据结构

## 在JDK7 : HashMap 是由 数组 和 链表 组成的
    
    数组查询快，增删改慢
    链表查询慢，增删改快

## 什么是哈希算法？
   
   哈希算法（也叫散列），就是把任意长度值（key）通过散列算法变换成固定长度的key(地址)， 通过这个地址进行访问的数据结构，
   它通过把关键码值映射到表中一个位置来访问记录，以加快查找速度。

## 什么是hash冲突
    
    lies 的值通过ascii 码计算的总和为 429
    foes 的值通过ascii 码计算的总和也为 429
    两个单词取模后的值都是 9 ，则lies 会存在下标为9 的这个位置，foes 也存在下标为9的这个位置，而数组存在同一个下标下面是会覆盖的（插入数组Intergers[9]=400,会覆盖Intergers[9]=2 的值，最终Intergers[9] =400）,同样我们先存的是lies 后存的是foes,则lies将会被覆盖，lies 和 foes 是不同的key, 我们HashMap是可以存这两个值的，为什么没有被覆盖了？这个地方就叫做哈希碰撞！

## Hash冲突怎么解决了
  
    我们用链表来解决这个问题, 链表是有一个指针的，我们可以让这个lies 指向这个foes,我们让foes 去匹配下标为9 的这个节点，如果匹配lies 不相等，则去匹配下一个节点foes,最终就会找到这个foes,这就是我们hash 算法底层的原理及解决冲突。

## 在JDK8: HashMap 是由 数组，链表，红黑树 组成的

## 解决链表过长查询效率过低的问题

    使用 红黑树

