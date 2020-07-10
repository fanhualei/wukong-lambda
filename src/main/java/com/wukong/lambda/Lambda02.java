package com.wukong.lambda;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// 参考网站 https://www.bilibili.com/video/BV1sE411P7C1?p=2

/**
 * 如何对集合进行操作，替换for循环
 */
public class Lambda02 {

    public static void main(String[] args) {
        List<String> list=  Arrays.asList("php","java","python","javascript");
        List<String> listSorted =list.stream() // 转变成流
                .filter(s->s.startsWith("j"))  // 过滤 j开头的
                .map(String::toUpperCase)      // 每一个展开，并调用 String.toUpperCase的方法
                .sorted()                      // 排序，可以自己写排序方法
                .collect(Collectors.toList()); // 把流转成List

        System.out.println("list = " + Arrays.deepToString(listSorted.toArray()));

        //数组也可以作 Stream.of
        String[] strArray= {"php","java","python","javascript"};

        List<String> listSorted2 = Stream.of(strArray) // 转变成流
                .filter(s->s.startsWith("j"))  // 过滤 j开头的
                .map(String::toUpperCase)      // 每一个展开，并调用 String.toUpperCase的方法
                .sorted()                      // 排序，可以自己写排序方法
                .collect(Collectors.toList()); // 把流转成List

        System.out.println("strArray  = " + Arrays.deepToString(listSorted2.toArray()));

        // 也可以用Set Map


        // 也可以文件
        try{
            URL path= Lambda02.class.getResource("/");
            Stream<String> stringStream = Files.lines(Paths.get(path.getPath(),"file.txt"));
            List<String> listSorted3 = stringStream // 转变成流
                    .filter(s->s.startsWith("j"))  // 过滤 j开头的
                    .map(String::toUpperCase)      // 每一个展开，并调用 String.toUpperCase的方法
                    .sorted()                      // 排序，可以自己写排序方法
                    .collect(Collectors.toList()); // 把流转成List

            System.out.println("file.txt  = " + Arrays.deepToString(listSorted3.toArray()));
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
