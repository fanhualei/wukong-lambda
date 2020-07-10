package com.wukong.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * 是否包含某一个“匹配规则”的元素  anyMatch
 * 是否所有的元素都符合某一个“匹配规则”  allMatch
 * 是否所有元素都不符合某一个“匹配规则”  noneMatch
 * 查找第一个符合“匹配规则”的元素  filter(e -> e.getAge() > 40).findFirst();
 * 查找任意一个符合“匹配规则”的元素 findAny
 *
 * 元素查找与Optional
 * 如果存在：ifPresent ，可以执行一个操作
 *
 *
 */
public class Lambda09 {
    public static void main(String[] args) {
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

        boolean isExistAgeThan70 =false;
        for(Employee e:employees){
            if(e.getAge()>70){
                isExistAgeThan70=true;
                break;
            }
        }

        isExistAgeThan70=employees.stream().anyMatch(e->e.getAge()>70);
        System.out.println(isExistAgeThan70);

        //其中使用到了我们之前学过的"谓词逻辑"。
        isExistAgeThan70=employees.stream().anyMatch(Employee.ageGreaterThan20);
        System.out.println(isExistAgeThan70);

        //元素查找与Optional
        Optional<Employee> optE=employees.stream().filter(e->e.getAge()>20).findFirst();
        System.out.println(optE.get());
        optE.isPresent(); //是否存在
        optE.isEmpty();   //是否为空


        Employee newE =new Employee(1,2,"M","tom","");

        employees.stream().filter(e->e.getAge()>20).findFirst()
                .ifPresent(System.out::println);

        //如果找到了，就print value，否则 print null
        employees.stream().filter(e->e.getAge()>120).findFirst()
                .ifPresentOrElse(System.out::println,()->System.out.println("null"));

        //使用orElse 如果没有找到，就返回一个默认
        Employee optE2 =employees.stream().filter(e->e.getAge()>20).findFirst()
                .orElse(newE);

    }

}
