# lambda 学习

`学lambda是为了让别人看不懂代码，哈哈`



# 1 注意事项

* steam有并行与串行计算，在并行计算时，如果是有状态操作函数，有可能会引发bug.

  



# 2 代码说明



## 2.1 例子1

* [恕我直言：你可能真的不会java编程-文章](https://www.kancloud.cn/hanxt/javacrazy/1572192)
* [B站视频](https://www.bilibili.com/video/BV1sE411P7C1?p=1)







| 代码                                                         | 说明                                                         |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| [Lambda01](src/main/java/com/wukong/lambda/Lambda01.java)    | 如何看懂lambda的各种缩写。()->  ::  <br/>如何定义一个接口函数 |
| [Lambda03](src/main/java/com/wukong/lambda/Lambda02.java)    | 初识Stream-API<br>1、Stream API代替for循环<br>2、将数组转换为管道流 : 使用Stream.of()方法<br>3、将集合类对象转换为管道流 : stream()方法<br>4、将文本文件转换为管道流 : Files.lines方法 |
| [Lambda03](src/main/java/com/wukong/lambda/Lambda03.java)    | Stream的filter与谓语逻辑<br>什么是谓词逻辑？<br>谓词逻辑的复用<br>1:and语法（并集）<br>2:or语法（交集）<br>3:negate语法（取反） |
| [Lambda04](src/main/java/com/wukong/lambda/Lambda04.java)<br>[Lambda04FlatMap](src/main/java/com/wukong/lambda/Lambda04FlatMap.java) | Stream管道流的map操作<br>1 map操作<br>2 flatMap操作：处理二维数组及二维集合类 |
| [Lambda05](src/main/java/com/wukong/lambda/Lambda05Map.java) | Stream的状态与并行操作<br>中间操作：有状态与无状态<br>串行、并行与顺序<br>并行操作的适用场景 |
| [Stream性能差?不要人云亦云](https://www.kancloud.cn/hanxt/javacrazy/1588494) | 对于简单的数字(list-Int)遍历，普通for循环效率的确比Stream串行流执行效率高（1.5-2.5倍）。<br>但是Stream流可以利用并行执行的方式发挥CPU的多核优势,因此并行流计算执行效率高于for循环。<br> 对于list-Object类型的数据遍历，普通for循环和Stream串行流比也没有任何优势可言，更不用提Stream并行流计算。<br>Stream并行流计算 >> 普通for循环 ~= Stream串行流计算 (之所以用两个大于号，你细品)<br>数据容量越大，Stream流的执行效率越高。<br>Stream并行流计算通常能够比较好的利用CPU的多核优势。CPU核心越多，Stream并行流计算效率越高。<br>junitperf 性能测试代码 |
| [Lambda06](src/main/java/com/wukong/lambda/Lambda06.java)    | 像使用SQL一样排序集合<br>**先按照性别字段倒序排序，再按照年龄的倒序**<br>sort方法:<br>    按照String.CASE_INSENSITIVE_ORDER（字母大小写不敏感）的规则排序<br>    使用Comparator.naturalOrder()字母自然顺序排序<br>    Comparator.reverseOrder() 倒序排序<br>Comparator链对`List<Object>`排序<br>    comparing thenComparing |
| [Lambda08](src/main/java/com/wukong/lambda/Lambda08.java)    | 函数式接口Comparator<br>函数式接口的特点<br>default关键字<br>JDK中的函数式接口举例<br>自定义Comparator排序 |
| [Lambda09](src/main/java/com/wukong/lambda/Lambda09.java)    | Stream查找与匹配元素<br>* 是否包含某一个“匹配规则”的元素  anyMatch <br/>* 是否所有的元素都符合某一个“匹配规则”  allMatch <br/>* 是否所有元素都不符合某一个“匹配规则”  noneMatch <br/>* 查找第一个符合“匹配规则”的元素  filter(e -> e.getAge() > 40).findFirst(); <br/>* 查找任意一个符合“匹配规则”的元素 findAny <br/>* <br/>* 元素查找与Optional <br/>* 如果存在：ifPresent ，可以执行一个操作 |
| [Lambda10](src/main/java/com/wukong/lambda/Lambda10.java)    | Stream集合元素归约reduce                                     |
| [StreamAPI终端操作](https://www.kancloud.cn/hanxt/javacrazy/1641151) |                                                              |
| [java8如何排序Map](https://www.kancloud.cn/hanxt/javacrazy/1641153) |                                                              |



![](http://cdn.zimug.com/javaStream1-2.jpg)





![](https://img.kancloud.cn/78/f7/78f74991175f6ddc5c27fff109f0fc66_942x578.png)