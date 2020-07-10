package com.wukong.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
//java默认对数组进行一些排序
public class Lambda06 {
    public static void main(String[] args) {

        List<String> alpha = Arrays.asList("Monkey","Lion","Giraffe","Lemur","Lion");
        System.out.println(alpha);

        // 系统实现了一些排序规则
        alpha.sort(String.CASE_INSENSITIVE_ORDER);
        System.out.println(alpha);

        alpha.sort(Comparator.naturalOrder());
        System.out.println(alpha);


        //按对象字段对List<Object>排序
        Employee e1 = new Employee(1,23,"M","Rick","Beethovan");
        Employee e2 = new Employee(2,13,"F","Martina","Hengis");
        Employee e3 = new Employee(3,43,"M","Ricky","Martin");
        Employee e4 = new Employee(4,26,"M","Jon","Lowman");
        Employee e5 = new Employee(5,19,"F","Cristine","Maria");
        Employee e6 = new Employee(6,15,"M","David","Feezor");
        Employee e7 = new Employee(7,68,"F","Melissa","Roy");
        Employee e8 = new Employee(8,79,"M","Alex","Gussin");
        Employee e9 = new Employee(9,15,"F","Neetu","Singh");
        Employee e10 = new Employee(10,45,"M","Naveen","Jain");


        List<Employee> employees = Arrays.asList(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10);

        //使用员工的年龄作为排序字段
        employees.sort(Comparator.comparing(Employee::getAge));
        employees.forEach(System.out::println);

        //如果我们希望List按照年龄age的倒序排序，就使用reversed()方法。如：
        employees.sort(Comparator.comparing(Employee::getAge).reversed());
        employees.forEach(System.out::println);

        //下面这段代码先是按性别的倒序排序，再按照年龄的倒序排序。
        employees.sort(
                Comparator.comparing(Employee::getGender)
                        .thenComparing(Employee::getAge)
                        .reversed()
        );
        employees.forEach(System.out::println);

    }
}
