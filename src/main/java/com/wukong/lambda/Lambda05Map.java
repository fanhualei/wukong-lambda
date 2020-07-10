package com.wukong.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 五状态：map filter flatMap
 * 有状态: distinct limit skip sorted  当前元素与其他元素进行比较，得到一个状态
 */
public class Lambda05Map {
    public static void main(String[] args) {
        List<String> alpha = Arrays.asList("Monkey","Lion","Giraffe","Lemur","Lion");

        //取前2个 limit
        alpha.stream().limit(2).forEach(System.out::println);
        System.out.println("");

        //跳过前2个 skip
        alpha.stream().skip(2).forEach(System.out::println);
        System.out.println("");

        //distinct
        alpha.stream().distinct().forEach(System.out::println);
        System.out.println("");

        //sorted
        alpha.stream().sorted().forEach(System.out::println);
        System.out.println("");
        //
        alpha.stream()
                .parallel()  //并行操作，不建议用到有状态操作，建议用到:array list map.
                .limit(2)
                .forEach(System.out::println);

        System.out.println("");
        alpha.stream()
                .sequential() // 串行，默认，速度没有并行快
                .limit(2)
                .forEach(System.out::println);




    }
}
