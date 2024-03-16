package org.jingtao8a.api;

import lombok.ToString;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;
import java.util.*;

public class DataStructure {
    @Test
    public void testString() throws UnsupportedEncodingException {
        String str = "123";
        char[] cs = new char[]{'1', '2', '3'};
        String str1 = new String(cs);
        byte[] bs = str.getBytes("utf-8");
        String str2 = new String(bs, "utf-8");
        System.out.println(str);
        System.out.println(str1);
        System.out.println(str2);
    }
    @Test
    public void testStringCompare() {
        String str1 = "abc";
        String str2 = new String("abc");
        System.out.println(str1 == "abc");
        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));
        System.out.println(str1.equalsIgnoreCase("aBC"));

        System.out.println(str1.compareTo("abd"));//小于返回 负数
        System.out.println(str1.compareTo("abc"));//相同返回值为 0
        System.out.println(str1.compareTo("abb"));//大于返回 正数

        System.out.println(str1.compareToIgnoreCase("ABD"));//小于返回 负数
        System.out.println(str1.compareToIgnoreCase("ABC"));//相同返回值为 0
        System.out.println(str1.compareToIgnoreCase("ABB"));//大于返回 正数
    }

    @Test
    public void testStringBasicFunction() {
        String str1 = "1233444";
        System.out.println(str1.concat("2"));
        System.out.println(str1.indexOf("3"));
        System.out.println(str1.lastIndexOf("4"));

        System.out.println(str1.substring(3));
        System.out.println(str1.substring(2, 4));

        System.out.println(str1 + 100);

        System.out.println(str1.replace("33", "44"));
        //程序当中直接写上的双引号字符串，就在字符串常量池中
        //用 +得到的
        //new 出来的不再
    }

    @Test
    public void testStringBuilder() {
        StringBuilder builder = new StringBuilder();
        StringBuilder builder1 = builder.append("hello");
        builder1.append(100).append(false);
        builder1.append(true);
        System.out.println(builder1.toString());
    }

    @Test
    public void testArrayList() {
        ArrayList<String> list = new ArrayList<>();
        list.add("123");
        list.add("324");
        list.add(0, "fjksd");
        list.add(0, "fjalk");
        System.out.println(list.remove(3));
        System.out.println(list.get(1));
        System.out.println(list.size());
//        list.clear();
//        System.out.println(list.size());
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        for (String a : list) {
            System.out.println(a);
        }
    }

    @Test
    public void testLinkedList() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.addFirst("123");
        linkedList.addLast("456");
        linkedList.addLast("789");
//        System.out.println(linkedList.removeFirst());
//        System.out.println(linkedList.removeLast());
        linkedList.push("456");
        System.out.println(linkedList.pop());
//        for (String str : linkedList) {
//            System.out.println(str);
//        }
    }

    @Test
    public void testSet() {
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        set1.add("a");
        set1.add("b");
        set1.add("c");

        set2.add("c");
        set2.add("d");
        set2.add("e");
        //交集
        set1.retainAll(set2);

        System.out.println("交集是 " + set1);
    }

    @Test
    public void testStack() {
        //Stack集成vector
        Stack<String> s = new Stack<>();
        s.push("wajlfs");
        s.push("fjsdkl");
        s.push("fjkas");
        for (int i = 0; i < s.size(); ++i) {
            System.out.println(s.get(i));
        }
        System.out.println(s.peek());
        System.out.println(s.pop());
    }

    @ToString
    static class Student implements Comparable<Student> {
        private int id;
        private String name;
        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }
        @Override
        public int compareTo(Student o) {// id降序
            return o.id - this.id;
        }
    }
    @Test
    public void testPriorityQueue() {
        PriorityQueue<Student> pq = new PriorityQueue<>();
        Student s1 = new Student(2, "lisi");
        Student s2 = new Student(1, "sak");
        Student s3 = new Student(3, "zhangsan");
        Student s4 = new Student(4, "zhang");
        pq.offer(s1);
        pq.offer(s2);
        pq.offer(s3);
        pq.offer(s4);
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }

    @Test
    public void testHashMap() {
        HashMap<String, String> map = new HashMap<>();
        map.put("123", "fkla");
        map.put("fks", "jfd");
        map.put("1244", "fjjd");

        Set<String> keys = map.keySet();
        for (String key : keys) {
            String value = map.get(key);
            System.out.println(key + " " + value);
        }

        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        for (Map.Entry<String, String> entry : entrySet) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    @Test
    public void testHashMapSort() {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("wangchen",98);
        hashMap.put( "xia",96);
        hashMap.put( "ta",85);
        hashMap.put( "hu",77);

        System.out.println("名字升序:");
        Set<String> keySet = hashMap.keySet();
        Object[] array = keySet.toArray();

        Arrays.sort(array);
        for (Object o : array) {
            System.out.println(o + " " + hashMap.get(o));
        }

        System.out.println("成绩升序:");
        Set<Map.Entry<String, Integer>> entrySet = hashMap.entrySet();
        ArrayList<Map.Entry<String, Integer>> al = new ArrayList<>(entrySet);
        Collections.sort(al, (o1, o2) -> { return o1.getValue() - o2.getValue(); });
        for (Map.Entry<String, Integer> e : al) {
            System.out.println(e.getKey() + " " + e.getValue());
        }
    }
}
