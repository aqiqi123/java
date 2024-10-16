import java.io.BufferedReader;
import java.io.*;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void printArray(int[] arr) {
        for(int i:arr){
            System.out.print(i+" ");
        }
    }

    //可变参数,即数量.类型不定的参数,一个方法只能有一个可变参数，而且必须是参数列表的最后一个参数
    public static void printMax(double...numbers){
        if(numbers.length==0){
            System.out.println("No argument passed");
            return;
        }

        double result =numbers[0];

        for(int i=1;i<numbers.length;i++){
            if(numbers[i]>result){
                result = numbers[i];
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        //用于数组的增强for循环
        int [] numbers={1,2,3,4,5};

        for(int x:numbers){
            if(x==3){
                //可以理解为马上跳到下一次迭代
                continue;
            }
            System.out.println(x);
        }

        String [] names={"h","y","j","k"};

        for(String y:names){
            //用equals来比较字符串
            if(y.equals("j")){
                break;
            }
            System.out.println(y);
        }

        //没有break的话，如果匹配成功，下面的也会输出
        int i=1;
        switch (i){
            case 0:
                System.out.println(0);
            case 1:
                System.out.println(1);
            case 2:
                System.out.println(2);
            case 3:
                System.out.println(3);
                break;
            default:
                System.out.println(4);

        }

        //三角函数都可以用Math
        System.out.println(Math.sin(Math.PI/2));

        String site="www.baidu.com";
        int len=site.length();
        System.out.println(len);
        System.out.println("1."+site);

        //当需要对字符串修改时，用StringBuild或者StringBuffer,String也可以修改，但是每次修改都会创建新对象
        StringBuilder sb=new StringBuilder(10);
        sb.append("Run..");
        System.out.println(sb);
        sb.append("|");
        System.out.println(sb);
        sb.insert(0,"Run..");
        System.out.println(sb);
        sb.delete(0,2);
        System.out.println(sb);

        //StringBuffer 可以保证线程安全，但是性能不如StringBuilder
        StringBuffer sb2=new StringBuffer("Hello");
        sb2.append("World");
        sb2.append("!");
        System.out.println(sb2);
        sb2.delete(0,2);
        System.out.println(sb2);

        int size=5;
        int[] myList=new int[size];
        myList[0]=1;
        myList[1]=2;
        myList[2]=3;
        myList[3]=4;
        myList[4]=5;
        int total=0;
        for(int j=0;j<size;j++){
            total+=myList[j];
        }
        System.out.println(total);

        for(int x:myList){
            System.out.println(x);
        }

        printArray(myList);

        int[][] a=new int[2][3];

        //SimpleDataFormat 自定义日期表示
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try{
            System.out.println(sdf.format(date));
            Thread.sleep(1000*3);
            //要创建新的date对象，不然仅仅调用format时间是不会更新的
            date=new Date();
            System.out.println(sdf.format(date));
        }catch(Exception e){
            System.out.println("Got exception");
        }

        String line ="This order was placed for QT3000！ok?";
        String pattern ="(\\D*)(\\d+)(.*)";

        Pattern r = Pattern.compile(pattern);

        Matcher m = r.matcher(line);
        if(m.find()){
            System.out.println(m.group(0));
            System.out.println(m.group(1));
            System.out.println(m.group(2));
            System.out.println(m.group(3));
        }else{
            System.out.println("NO MATCH");
        }

        System.out.println("\\");
        System.out.println("\\\\");

        printMax(35,32,65,876,864,547);
        printMax(new double[]{1,2,3,4,5});

        //缓冲区用于临时储存数据，旨在提高性能
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

    }
}
