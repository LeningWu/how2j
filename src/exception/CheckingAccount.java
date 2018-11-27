package exception;

public class CheckingAccount extends Account{
    /*
    CheckingAccount 支票账户，具备透支额度，继承Account
     */
    private double overdraftProtection;
    /*
    public CheckingAccount(double balance,double protect){
        this.balance=balance;

    }*/

    /*public CheckingAccount(double balance){

    }
*/
    @Override
    public double withDraw(double amt) throws OverdraftException {
       if(amt>balance&amt-balance>overdraftProtection){
           throw new OverdraftException("透支超额",amt-balance-overdraftProtection);
       }
       return balance-amt;
    }

    public static void main(String[] args){
        CheckingAccount ac=new CheckingAccount();
        ac.overdraftProtection=500;
        ac.balance=600;
        try {
            System.out.println("取钱余额"+ac.withDraw(1200));
        } catch (OverdraftException e) {
            System.out.println("超出透支额度"+e.getDeficit());
            e.printStackTrace();
        }
    }
}
