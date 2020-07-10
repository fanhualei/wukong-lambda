package com.wukong.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lambda0401 {
    public static void main(String[] args) {
        Employee e1=new Employee(1,10,"M","tom","Jack");
        Employee e2=new Employee(2,16,"F","tom","Jams");
        Employee e3=new Employee(3,26,"M","tom","Soph");
        Employee e4=new Employee(4,36,"F","tom","Rose");
        Employee e5=new Employee(5,46,"M","tom","Li");

        List<Employee> employees= Arrays.asList(e1,e2,e3,e4,e5);
        //将每个员工的年龄增加1岁，将M male  F female
        List<Employee>  newList = employees.stream()
                .map(e->{
                    e.setAge(e.getAge()+1);
                    e.setGender(e.getGender().equals("M")?"male":"female");
                    return e;  //必须要返回
                })
                .collect(Collectors.toList());

        System.out.println(newList);

        //如果不详map ，使用peek
        List<Employee>  newList1 = employees.stream()
                .peek(e->{
                    e.setAge(e.getAge()+1);
                    e.setGender(e.getGender().equals("M")?"male":"female");
                })
                .collect(Collectors.toList());

        System.out.println(newList1);

    }
}
