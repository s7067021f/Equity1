import java.io.Serializable;

public class CashFlow implements Serializable {
    public int month; // keep it simpe to start, with 1 = July 2013, 2 = Augut 2013
    private double principal; 
    private double dividend;
    
    public CashFlow (int month, double principal, double dividend){
        this.month = month;
        this.principal = principal;
        this.dividend = dividend;
    }
    
    public int getCashFlowMonth(){
        return month;
    }
    
    public double getCashFlowPrincipal(){
        return principal;
    }
    
    public String toString(){
        return "Cashflow month " + month + ": Principal is " + principal + ", and dividend is " + dividend;
    }
} // end of class CashFlow
