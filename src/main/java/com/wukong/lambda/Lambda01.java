package com.wukong.lambda;

public class Lambda01 {

    //这个接口只能有一个方法，可以简化成接口函数
    interface Printer{
        void printer(String val);
    }

    //传入一个接口函数
    public void printSomething(String something,Printer printer){
        printer.printer(something);
    }

    public static void main(String[] args) {
        Lambda01 demo1=new Lambda01();
        String some="hello lambda";

        // 传统的方法 匿名类
        Printer  printer01 = new Printer() {
            @Override
            public void printer(String val) {
                System.out.println(val);
            }
        };
        printer01.printer(some);

        // 省略了 匿名类
        Printer printer02 = (String val) ->{
            System.out.println(val);
        };
        printer02.printer(some);

        // 省略了 参数的数据类型
        Printer printer03 = (val) ->{
            System.out.println(val);
        };
        printer03.printer(some);


        // 省略了 参数的圆括号，如果只有一个参数
        Printer printer04 = val ->{
            System.out.println(val);
        };
        printer04.printer(some);


        // 省略了 参数的花括号，如果只有一行代码
        Printer printer05 = val -> System.out.println(val);
        printer05.printer(some);


        // 将lambda作为参数传入程序。
        demo1.printSomething(some,val->{System.out.println(val);});

        //如果没有任何参数

    }

}
