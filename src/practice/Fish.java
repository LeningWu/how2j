package practice;

public class Fish extends Animal implements Pet{
    private String name;

    protected Fish(int legs) {
        super(legs);
    }

    @Override
    public void walk() {
        System.out.println("鱼没有腿不能走路");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void play() {
        System.out.println(this.name+"玩鱼");
    }



    @Override
    public void eat() {
        System.out.println(this.name+"吃鱼");
    }



}
