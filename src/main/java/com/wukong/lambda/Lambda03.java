package com.wukong.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 演示了在Employee 中定义 Predicate 谓词  filter
 */
public class Lambda03 {
    public static void main(String[] args) {
        Employee e1=new Employee(1,10,"M","tom","Jack");
        Employee e2=new Employee(2,16,"F","tom","Jams");
        Employee e3=new Employee(3,26,"M","tom","Soph");
        Employee e4=new Employee(4,36,"F","tom","Rose");
        Employee e5=new Employee(5,46,"M","tom","Li");

        List<Employee> employees= Arrays.asList(e1,e2,e3,e4,e5);

        List<Employee> filterList= employees.stream()
                .filter(e-> e.getAge()>20 && e.getGender().equalsIgnoreCase("M") )
                .collect(Collectors.toList());

        System.out.println(filterList);

        // 使用 and
        List<Employee> filterList2= employees.stream()
                .filter(Employee.ageGreaterThan20
                        .and(Employee.genderM))
                .collect(Collectors.toList());
        System.out.println(filterList2);

        // 使用 or
        List<Employee> filterList3= employees.stream()
                .filter(Employee.ageGreaterThan20
                        .or(Employee.genderM))
                .collect(Collectors.toList());
        System.out.println(filterList3);

        // 取反
        List<Employee> filterList4= employees.stream()
                .filter(Employee.ageGreaterThan20
                        .and(Employee.genderM)
                        .negate()   //
                )
                .collect(Collectors.toList());
        System.out.println(filterList4);
    }
}
