package com.wukong.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * https://www.kancloud.cn/hanxt/javacrazy/1641322
 * 10.Stream集合元素归约
 * Stream API为我们提供了Stream.reduce用来实现集合元素的归约。reduce函数有三个参数：
 *
 * Identity标识：一个元素，它是归约操作的初始值，如果流为空，则为默认结果。
 * Accumulator累加器：具有两个参数的函数：归约运算的部分结果和流的下一个元素。
 * Combiner合并器（可选）：当归约并行化时，或当累加器参数的类型与累加器实现的类型不匹配时，用于合并归约操作的部分结果的函数。
 *
 *
 */
public class Lambda10 {

    public static void main(String[] args) {

        //Integer类型归约
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int result = numbers.stream().reduce(0,(subTotal,element)->subTotal+element);
        System.out.println(result);  //21

        //简化的写法
        result = numbers.stream().reduce(0,Integer::sum);
        System.out.println(result);  //21


        // String类型归约
        List<String> letters = Arrays.asList("a", "b", "c", "d", "e");
        String resultString = letters
                .stream()
                .reduce("", (partialString, element) -> partialString + element);
        System.out.println(resultString);  //abcde


        resultString = letters
                .stream()
                .reduce("", String::concat);
        System.out.println(resultString);  //ancde

        //员工年龄求和
        List<Employee>  employees= Employee.getTestEmployeeList();
        Integer ageSum = employees.stream()
                .map(e->e.getAge()) //取出年龄
                .reduce(0,Integer::sum); //计算年龄

        System.out.println(ageSum);


        //上面代码用for循环更好,为什么还用lambda?
        Integer ageSum2=0;
        for(Employee e:employees){
            ageSum2= ageSum2+ e.getAge();
        }
        System.out.println(ageSum2);

        //因为可以进行并行
        Integer ageSum3= employees.parallelStream()
                .map(e->e.getAge())
                .reduce(0,Integer::sum,Integer::sum); //这里有第三个参数，Combiner合并器
        System.out.println(ageSum3);

        //Combiner合并器的使用， 没有通过map来进行类型转换
        Integer total3 = employees.stream()
                .reduce(0,(totalAge,emp) -> totalAge + emp.getAge(),Integer::sum); //注意这里reduce方法有三个参数
        System.out.println(total3); //346

    }
}
