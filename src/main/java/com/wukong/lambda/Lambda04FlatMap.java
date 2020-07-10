package com.wukong.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Lambda04FlatMap {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("hello","word");


        for(String s:words){
            String[] array= s.split("");
            for(String sub:array){
                System.out.println(sub);
            }
            System.out.println("");
        }

        //管道里面还有管道，或者数组
        words.stream().map(s->s.split(""))
                .forEach(System.out::println);

        //flatMap 解决for循环，嵌套for
        words.stream().flatMap(s-> Stream.of(s.split("")) )
                .forEach(System.out::println);




    }
}
