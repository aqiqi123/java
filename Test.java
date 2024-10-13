public class Test {
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


    }
}
