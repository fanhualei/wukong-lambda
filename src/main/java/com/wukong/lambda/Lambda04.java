package com.wukong.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lambda04 {
    public static void main(String[] args) {
        List<String> alpha = Arrays.asList("Monkey","Lion","Giraffe","Lemur");
        //使用for
        List<String> alphaUpper=new ArrayList<>();
        for(String s:alpha){
            alphaUpper.add(s);
        }
        System.out.println(alphaUpper);

        //使用lambda
        List<String> alphaUpper2=alpha.stream()
                .map(s->s.toUpperCase())
                .collect(Collectors.toList());

        System.out.println(alphaUpper2);

        //使用lambda
        List<String> alphaUpper3=alpha.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println(alphaUpper3);

        //直接答应，这里使用了方法，直接把参数给省略了
        alpha.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);

        //map 还可以进行转换
        alpha.stream().mapToInt(String::length).forEach(System.out::println);
        alpha.stream().mapToInt(String::length).forEach(e->System.out.println(e));



    }
}
