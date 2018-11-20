package practice;

public class Cat extends Animal implements Pet{
    String name;
    public Cat(String name){
        super(4);
        this.name=name;
    }

    public Cat(){
        this(" ");
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
        System.out.println(this.name+"在玩猫");
    }

    @Override
    public void eat() {
        System.out.println(this.name+"在吃猫");
    }

    @Override
    public void walk() {
        super.walk();
    }
}
