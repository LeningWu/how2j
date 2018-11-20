package practice;

public class Spider extends Animal{
    String name;
    public Spider(){
        super(8);
    }

    @Override
    public void eat(){
        System.out.println(this.name+"在吃点心");
    }

    @Override
    public void walk() {
        super.walk();
    }
}
