package test;

public class APADHero extends Hero implements AP,AD {
    @Override
    public void physicAttack(){
        System.out.println("进行物理攻击");
    }

    public void magicAttack(){
        System.out.println("进行魔法攻击");
    }
}
