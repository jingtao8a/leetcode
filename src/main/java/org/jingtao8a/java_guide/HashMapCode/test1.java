package org.jingtao8a.java_guide.HashMapCode;

public class test1 {
    // HashMap可以存储null的key和value, 但null作为键只能有一个，null作为值可以有多个
    // HashMap由 数组 + 链表 组成,数组是HashMap的主体，链表则是主要为了解决哈希冲突而存在(“拉链法”解决冲突)
    // 链表长度大于等于阈值（默认为8），将链表转换为红黑树,
    // (将链表转换成红黑树前会判断，如果当前数组的长度小于64，那么会选择先进行数组扩容，而不是转换为红黑树)
    // HashMap默认的初始化大小为16。之后每次扩充，容量变为原来的2倍。并且，hashMap总是使用2的幂作为哈希表的大小.
    public static void main(String[] args) {

    }
}
