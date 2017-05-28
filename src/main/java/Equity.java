import java.util.ArrayList;
import java.util.Scanner;
import java.io.Serializable;

public class Equity implements Serializable {
    private String name;
    private ArrayList<CashFlow> cf = new ArrayList<CashFlow>();
    private int position;
    private double price;
    
    public Equity(String name){
        this.name = name;
    }
    
    public Equity(String name, ArrayList<CashFlow> cf){
        this.name = name;
        this.cf = cf;
    }
    
    public String getEquityName(){
        return name;
    }
    
    public ArrayList<CashFlow> getCashFlowArrayList(){
        return cf;
    }
    
    public int getPosition(){
        return position;
    }
    
    public double getPrice(){
        return price;
    }
    
    public void setPosition(int p){
        position = p;
    }
    
    public void setPrice(double p){
        price = p;
    }
    
    public void createNewCashFlow(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the cashflow month (1 = July 2013): ");
        int month = sc.nextInt(); // improve: handle if input isn't integer
        System.out.println("Enter the principal (can enter 0): ");
        double principal = sc.nextDouble(); // improve: handle if input isn't double
        System.out.println("Enter the dividend (can enter 0): ");
        double dividend = sc.nextDouble(); // improve: handle if input isn't double
        cf.add(new CashFlow(month, principal, dividend));
        //sc.close();
    }
    
    
    public void printEquity(){
        printEquityName();
        System.out.println("Price is " + price + " and position is " + position);
        for (CashFlow c : cf){
            System.out.println(c.toString());
        }
    }
    
    public void printEquityName(){
        System.out.println("Equity name is "+name);
    }
    
} // end of class Equity
