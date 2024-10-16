import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamStudy {
    public static void main(String[] args) {

        //通过循环遍历列表，但是循环不是遍历的唯一方法
        List<String> list = new ArrayList<String>();
        list.add("abc");
        list.add("bac");
        list.add("acb");
        list.add("aad");
        list.add("cae");
        System.out.println(list);

        List<String> list1=new ArrayList<String>();
        for (String s:list){
            if(s.startsWith("a")){
                list1.add(s);
            }
        }
        System.out.println(list1);

        //下面通过stream来遍历列表,stream更简单，更优雅
        list.stream()
                //s->s是lambda表达式，表示没有名称的函数，可以多用于函数作为参数时的情况，可以使代码更简洁
                //lambda表达式有性能优化，简洁代码的好处
                .filter(s->s.startsWith("a"))//中间操作，不会立即执行，遇到终端操作才会执行
                .forEach(System.out::println);//终端操作，一个流只进行一次终端操作

        //接下来学习stream的创建
        //.stream()方法
        List<String> list_a= Arrays.asList("a","b","c","d");
        Stream<String> stream=list_a.stream();//顺序流，元素处理要按顺序
        Stream<String> stream1=list1.parallelStream();//并行流，元素可以多线程处理，性能好，但可能出现并发问题
        stream.forEach(System.out::println);

        System.out.println("并行流");
        stream1.forEach(System.out::println);

        //用数组创建stream
        int[] array={1,2,3,4,5};
        IntStream stream2 = Arrays.stream(array);//IntStream是一个专门处理整数的流，比Stream<Integer>更高效
        stream2.forEach(System.out::println);

        //使用stream的静态方法
        Stream<Integer> stream3=Stream.of(1,2,3,4,5);//创建一个包含指定数值的流
        stream3.forEach(System.out::println);

        Stream<Integer> stream4=Stream.iterate(1,i->i+1).limit(5);//创建一个按照给定种子和迭代函数的无限流
        stream4.forEach(System.out::println);

        Stream<Double> stream5=Stream.generate(Math::random).limit(5);//创建一个使用Math（或其他方法）方法生成元素的无限流
        stream5.forEach(System.out::println);

        //接下来学习stream的使用
        //了解Optional类，主要用于解决空指针异常，它表示可能存在或不存在的值
        //Stream中的元素就是以Optional类型存在的

        List<Integer> list2=Arrays.asList(1,2,3,4,5,9,8,7,6);

        //filter筛选，此外，注意java的函数式编程，好看
        list2.stream().filter(x->x>6).forEach(System.out::println);

        //匹配第一个值
        Optional<Integer> findFirst=list2.stream().filter(x->x>6).findFirst();
        findFirst.ifPresent(System.out::println);

        //匹配任意一个值
        Optional<Integer> findAny=list2.parallelStream().filter(x->x>6).findAny();
        findAny.ifPresent(System.out::println);

        //判断是否存在大于6的数
        boolean anyMatch=list2.stream().anyMatch(x->x>6);
        System.out.println(anyMatch);

        //聚合（max min count）
        //找最小
        Optional<Integer> max=list2.stream().min(Integer::compare);
        max.ifPresent(System.out::println);

        //找数目
        long count=list2.stream().filter(x->x>6).count();
        System.out.println(count);

        //映射（map flatmap）
        //collect是一个终端操作，返回一个收集器collector，用于将元素收集到一个list中
        List<Integer> list3=list2.stream().map(x->x+3).collect(Collectors.toList());
        System.out.println(list3);

        //flatMap可以将复杂的结构（嵌套，数组）扁平化，接受的参数是将一个流转换为另一个流的函数
        List<List<String>> nestedList=Arrays.asList(
                Arrays.asList("apple","banana"),
                Arrays.asList("boat","car"),
                Arrays.asList("man","woman")
        );

        //处理嵌套数据，一个班里有多个学生，每个学生选了多个不同的课，这就构成了一个嵌套列表，这时我们就可以通过flatMap得到包含所有课程的新列表
        List<String> flatList=nestedList.stream().flatMap(List::stream).collect(Collectors.toList());
        System.out.println(flatList);

        //一对多，例如我们可以将一段话的所有关键词提取出来
        List<String> words=Arrays.asList("apple","banana","car","man","woman");

        List<String> characters=words.stream().flatMap(word->Arrays.stream(word.split(""))).collect(Collectors.toList());
        System.out.println(characters);
        //flatMap将多个流合并成一个流可以减少内存压力

        //流不储存数据，所以流的数据处理完后，要将流归集到新的集合，例如用toCollection

        //通过partitioningBy和groupingBy可以实现分组
        //partitioningBy通过条件判断分组，适用与简单的二分类场景
        //groupingBy根据属性值进行分组，适合复杂的场景

        //发现东西好像还挺多的，为什么有些人说java不好啊
    }
}
