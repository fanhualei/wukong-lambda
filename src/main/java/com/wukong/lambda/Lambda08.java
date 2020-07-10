package com.wukong.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * https://www.kancloud.cn/hanxt/javacrazy/1605260
 *二、函数式接口的特点
 * 接口有且仅有一个抽象方法，如上图的抽象方法compare
 * 允许定义静态非抽象方法
 * 允许定义默认defalut非抽象方法（default方法也是java8才有的，见下文）
 * 允许java.lang.Object中的public方法，如上图的方法equals。
 * FunctionInterface注解不是必须的，如果一个接口符合"函数式接口"定义，那么加不加该注解都没有影响。加上该注解能够更好地让编译器进行检查。如果编写的不是函数式接口，但是加上了@FunctionInterface，那么编译器会报错
 * 甚至可以说：函数式接口是专门为lambda表达式准备的，lambda表达式是只实现接口中唯一的抽象方法的匿名实现类。
 *
 * 三、default关键字
 * 顺便讲一下default关键字，在java8之前
 *
 * 接口是不能有方法的实现，所有方法全都是抽象方法
 * 实现接口就必须实现接口里面的所有方法
 * 这就导致一个问题：当一个接口有很多的实现类的时候,修改这个接口就变成了一个非常麻烦的事,需要修改这个接口的所有实现类。
 *
 * 这个问题困扰了java工程师许久，不过在java8中这个问题得到了解决,没错就是default方法
 *
 * default方法可以有自己的默认实现，即有方法体。
 * 接口实现类可以不去实现default方法，并且可以使用default方法。
 * 四、JDK中的函数式接口举例
 * java.lang.Runnable,
 *
 * java.util.Comparator,
 *
 * java.util.concurrent.Callable
 *
 * java.util.function包下的接口，如Consumer、Predicate、Supplier等
 *
 *
 *
 */
public class Lambda08 {
    public static void main(String[] args) {
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

        // 用自定义接口实现类的的方式实现：按照年龄的倒序排序！
        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee em1, Employee em2) {
                if(em1.getAge() == em2.getAge()){
                    return 0;
                }
                return em1.getAge() - em2.getAge() > 0 ? -1:1;
            }
        });
        employees.forEach(System.out::println);


        //以lambda表达式简写。箭头左侧是参数，右侧是函数体，参数类型和返回值根据上下文自动判断。如下：
        employees.sort((em1,em2) -> {
            if(em1.getAge() == em2.getAge()){
                return 0;
            }
            return em1.getAge() - em2.getAge() > 0 ? -1:1;
        });
        employees.forEach(System.out::println);
    }



}
