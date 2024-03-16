package org.jingtao8a.api;

import lombok.ToString;

import java.util.ArrayList;
import java.util.Collections;

public class CollectionsKind {
    @ToString
    static class Student implements Comparable<Student> {
        private String name;
        private Integer age;
        public Student(String name, Integer age) {
            this.name = name;
            this.age = age;
        }
        @Override
        public int compareTo(Student o) {
            if (this.age == o.age) {
                return this.name.charAt(0) - o.name.charAt(0);//名字首字母升序
            } else {
                return this.age - o.age;//年龄升序
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Student> al = new ArrayList<>();
        Collections.addAll(al, new Student("cchen",20),new Student("achen",23),new Student("bchen",21));
        System.out.println(al);
        Collections.sort(al);
        System.out.println(al);
        Collections.sort(al, (o1, o2)-> { return o1.name.charAt(0) - o2.name.charAt(0); });
        System.out.println(al);
    }
}
