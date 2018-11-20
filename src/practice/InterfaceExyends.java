package practice;

public class InterfaceExyends {
    public static void main(String[] args){
        Spider spider =new Spider();
        spider.name="蜘蛛";
        spider.eat();
        System.out.println("-----------------");

        Cat cat = new Cat("汤姆猫");
       // cat.name="汤姆猫";
       // cat.setName("tom");
        cat.eat();
        cat.play();
        System.out.println("----------------");

        Fish fish =new Fish(0);
        fish.setName("jerry");
        fish.getName();
        fish.eat();
        fish.play();
        fish.walk();

    }
}
