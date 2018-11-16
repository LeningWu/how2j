public class Support extends Hero {
    public void heal(){
        System.out.println("给英雄加血");
    }

    public void heal(Hero h){
        System.out.println("给"+h.name+"加血");
    }

    public void heal(Hero h,int hp){
        System.out.println("给"+h.name+"加"+hp+"血");
    }

    public static void main(String[] args){
        Support a=new Support();
        Hero h =new Hero();
        h.name="sabor";
        a.heal();
        a.heal(h);
        a.heal(h,100);
    }
}
