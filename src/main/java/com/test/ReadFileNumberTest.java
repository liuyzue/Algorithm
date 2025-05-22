package com.test;

import com.model.Student;

import java.util.*;

public class ReadFileNumberTest {
    public static void main(String[] args) {
        Map<String, Student> map = new HashMap<String, Student>();
        Student student = new Student();
        student.setName("111");
        map.put("1", student);

        map.get("1").setName("222");
        List<Student> students = new ArrayList<>(map.values());
        students.forEach(System.out::println);
    }
}
