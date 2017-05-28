import java.util.ArrayList;
import java.io.Serializable;
import java.io.*;

public class Equities implements Serializable {
    public ArrayList<Equity> myEquities = new ArrayList<Equity>();
    //int months = getLatestCashFlowMonth();
    //double[] monthTotals = new double[months];
    
    public void printEquities(){
        for (Equity eq : myEquities){
            eq.printEquity();
        }   
    }
    
    public void saveEquities(){
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("equities.ser"));
            out.writeObject(myEquities);
            out.close();
            System.out.println("***Serialized data has been saved in equities.ser***");
      } catch(IOException i) {
         i.printStackTrace();
        }
      }
      
    public void loadEquities() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("equities.ser"));
            myEquities = (ArrayList<Equity>) in.readObject(); // improve: put an if isObject arraylist Equity around this
            in.close();
            System.out.println("***Serialized data has been loaded into myEquities ArrayList***");
        } catch(Exception ex) {
              ex.printStackTrace();
        }
      }
      
    public int getNumberOfEquities(){
        return myEquities.size();
    }
    
    public int getLatestCashFlowMonth(){
        int latest = 0;
        for (Equity eq : myEquities){
            for (CashFlow c : eq.getCashFlowArrayList()){
                if (c.month > latest){
                    latest = c.month;
                }
            }
        }
        return latest;
    }
    
    public void printEquitiesPretty(){
        System.out.println("number of Equities: " + getNumberOfEquities());
        System.out.println("latest CashFlow month: " + getLatestCashFlowMonth());
        int months = getLatestCashFlowMonth();
        double[] monthTotals = new double[months];
        System.out.print("          ");
        for (int i = months; i > 0; i--){
            System.out.printf("%07d | ",i);
        }
        for (Equity eq : myEquities){
            System.out.println();
            System.out.printf("%-10s",eq.getEquityName());
            for (int i = months; i > 0; i--){
                boolean printedForThisMonth = false;
                for (CashFlow c : eq.getCashFlowArrayList()){
                    if (c.getCashFlowMonth() == i){
                        System.out.printf("%,7.0f | ",c.getCashFlowPrincipal());
                        printedForThisMonth = true;
                        monthTotals[i-1] += c.getCashFlowPrincipal();
                        //System.out.println("debug " + i + monthTotals[i-1]);
                    }
                }
                if (!printedForThisMonth) {
                    System.out.print("        | ");
                }
            }
        }
        System.out.println();
        System.out.printf("%10s","TOTAL");
        for (int i = months-1; i >= 0; i--){
            System.out.printf("%,7.0f | ",monthTotals[i]);
        }
    } // end of printEquitiesPretty

} // end of class Equities

