class Animal {
    private String name;
    private int id;

    //无参构造器
    public Animal() {
        System.out.println("super");
    }

    //带参数构造器
    public Animal(String myName, int myId) {
        name = myName;
        id = myId;
    }
    public void eat() {
        System.out.println(name+" eats animal");
    }
    public void sleep() {
        System.out.println(name+" sleeps animal");
    }
    public void introduction() {
        System.out.println(name+" introduction "+id);
    }
}

//Java的继承可以放在不同的文件，但是每个文件只能有一个public类，并且该类与文件名相同
//public类可以在不同的包中访问
class Penguin extends Animal{

    //无参构造器不需要super即可自动调用父类构造器
    public Penguin() {
        System.out.println("sub");
    }

    //带参数构造器，必须用super显示调用父类构造器
    public Penguin(String myName, int myId) {
        super(myName, myId);
    }

    //重载可以看成同名方法有不同参数和方法
    //重写只改写父类的方法，其他的不变
    //重写是父类与子类间多态性的表现，重载是同一个类里多肽性的表现
    @Override
    public void eat() {
        System.out.println("eats penguin");
    }
}

//this访问自己的方法，super访问对象的方法
public class Test1 {
    public static void main(String[] args) {
        Penguin p = new Penguin("Penguin", 1);
        p.eat();
        p.sleep();
        p.introduction();

        Animal a = new Penguin("Penguin", 2);
        a.eat();
        a.sleep();
        a.introduction();
    }
}


