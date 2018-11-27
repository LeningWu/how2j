package exception;

public class Account {
    /*
    Account类： 银行账号
    属性： balance 余额
    方法： getBalance() 获取余额
    方法： deposit() 存钱
    方法： withdraw() 取钱
    OverdraftExcetpion： 透支异常，继承Exception
    属性： deficit 透支额
     */
    protected double balance;


    public void Account(double init){
        balance=init;
    }

    public double getBalance(){
        return balance;
    }

    public double deposit(double amt){
         balance=balance+amt;
         return balance;
    }

    public double withDraw(double amt) throws OverdraftException{
        if (amt>balance){
            throw new OverdraftException("透支了",amt-balance);
        }
        return balance-amt;
    }

    public static void main(String[] args){
        Account a=new Account();
        a.Account(1000);
        //a.balance=1000;
        System.out.println(a.getBalance());
        a.deposit(1);
        System.out.println(a.getBalance());
        try {
            System.out.println(a.withDraw(1100));
        }catch (OverdraftException e){
            System.out.println(e.getMessage());
            System.out.println("透支金额为"+e.getDeficit());
            e.printStackTrace();
        }
    }

}
