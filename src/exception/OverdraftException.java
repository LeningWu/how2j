package exception;


public class OverdraftException extends Exception{
    /*
    OverdraftExcetpion： 透支异常，继承Exception
    属性： deficit 透支额
     */
    private double deficit;
    public double getDeficit(){
        return deficit;
    }

    public OverdraftException(String message,double deficit){
        super(message);
        this.deficit=deficit;
    }
}
