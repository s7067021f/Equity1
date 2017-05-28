import java.util.Scanner;

public class Runner {    
    static Equities testMyEquities = new Equities();
    
    public static void main(String[] args){
        // Equities testMyEquities = new Equities(); // prior to having a static variable called testMyEquities
        testMyEquities.loadEquities();
        askUserForAction();
    } // end of main    
       
    public static void askUserForAction(){
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("What do you want to do?");
        System.out.println("(1) add new Equity");
        System.out.println("(2) print all Equities");
        System.out.println("(3) remove an Equity");
        System.out.println("(4) print all Equities real pretty");
        System.out.println("(5) edit price");
        System.out.println("(6) edit position");
        System.out.println("(7) delete cashflow");        
        System.out.println("(9) quit");
        System.out.println();
        int answer = sc.nextInt(); // improve: handle if input isn't integer
        switch (answer){
            case 1:
                addNewEquity();
                testMyEquities.saveEquities();
                askUserForAction();
                break;
            case 2:
                testMyEquities.printEquities();
                System.out.println();
                askUserForAction();
                break;
            case 3:
                removeEquity();
                testMyEquities.saveEquities();
                askUserForAction();
                break;
            case 4:
                testMyEquities.printEquitiesPretty();
                System.out.println();
                askUserForAction();   
                break;
            case 5:
                editPrice();
                testMyEquities.saveEquities();
                askUserForAction();
                break;
            case 6:
                editPosition();      
                testMyEquities.saveEquities();
                askUserForAction();
                break;
            case 7:
                //deleteCashFlow();      
                testMyEquities.saveEquities();
                askUserForAction();
                break;                
            case 9:
                break;
            default:
                break;
        }
    } // end of askUserForAction
    
    public static void addNewEquity(){
        Scanner sc = new Scanner(System.in);
        System.out.println("What's the name of the Equity?");
        String name = sc.next();
        Equity equity = new Equity(name);
        testMyEquities.myEquities.add(equity);
        System.out.println("Add a cashflow? y/n");
        while (sc.next().equals("y")){
            equity.createNewCashFlow(); 
            System.out.println("Add a cashflow? y/n");
        }
    }// end of addNewEquity
    
    public static void removeEquity(){
        theseAreYourEquities();
        System.out.println("Enter the number of the Equity to remove");
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        String name = testMyEquities.myEquities.get(i).getEquityName();        
        testMyEquities.myEquities.remove(i);
        System.out.println("You removed " + name);
    }
    
    public static void editPrice(){
        theseAreYourEquities();
        System.out.println("Enter the number of the Equity to change the price");
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        System.out.println("What's the price?");
        double d = sc.nextDouble();
        testMyEquities.myEquities.get(i).setPrice(d);        
    }
    
    public static void editPosition(){
        theseAreYourEquities();
        System.out.println("Enter the number of the Equity to change the position");
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        System.out.println("Current position is " + testMyEquities.myEquities.get(i).getPosition());
        System.out.println("What's the new position?");
        int d = sc.nextInt();
        testMyEquities.myEquities.get(i).setPosition(d);         
    }
    
    public static void theseAreYourEquities(){
        System.out.println("These are your Equities:");
        for (Equity eq : testMyEquities.myEquities){
            System.out.println(testMyEquities.myEquities.indexOf(eq) + ": " + eq.getEquityName());
        }
    }

} // end of class Runner

/*
 *     public void deleteCashFlow(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the cashflow month (1 = July 2013) to delete: ");
        int month = sc.nextInt(); // improve: handle if input isn't integer
        for (CashFlow c : cf){
            if (c.getCashFlowMonth() == month){
                cf.remove(cf.indexOf(c));
            }
        }
    }
*/

