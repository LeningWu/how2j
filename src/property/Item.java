package property;

public class Item extends Object{
    String name;
    int price;

    /*
    public void buy(){
        System.out.println("购买");
    }

    public void effect(){
        System.out.println("物品使用后有效果");
    }*/

    public String toString(){
        return name+price;
    }

    public void finalize(){
        System.out.println("正在回收"+name);
    }

    public boolean equals(Object o) {
        if (o instanceof Item){
            Item i=(Item) o;
            if (i.price==this.price)
                return true;
            else
                return false;
        }
        return false;
    }

    public static void main(String[] args){
        /*
        Item i1 = new LifePotion();
        Item i2 = new MagicPotion();
        System.out.println("i1 is Item ,do effect");
        i1.effect();
        System.out.println("i2 is Item ,do effect");
        i2.effect();
        */
    }

}
