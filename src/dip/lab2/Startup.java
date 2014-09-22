package dip.lab2;

// An useful import if you need it.
import java.text.NumberFormat;
// Another useful import if you need it.
import javax.swing.JOptionPane;

/**
 * Just a test class for input and output.
 *
 * 1. Create instances of low-level classes using Liskov Substitution principle.
 * 2. Create an instance of your high-level class.
 * 3. Pass one of your calculator instances to the high-level class and
 *    check the results.
 * 4. Now switch to a different calculator instance and pass that to the
 *    high-level class. Did it work? Are the low-level instances
 *    interchangeable? The DIP requires this.
 * 
 * @author Dylan Barter
 */
public class Startup {
     
    public static void main(String[] args) {
        //Initialize bag count
        int bagNum = 6;
        //Initialize food bill amount
        double billAmt = 88.00;
        
        //Determine the quality of service via the ENUM
        
//        ServiceQuality serviceQual = ServiceQuality.FAIR;
        ServiceQuality serviceQual = ServiceQuality.GOOD;
//        ServiceQuality serviceQual = ServiceQuality.POOR;
        
        //This portion is strictly to make the system out string look prettier
        String quality = "";
        switch(serviceQual){
            case GOOD:
                quality = "good";
                break;
            case FAIR:
                quality = "fair";
                break;
            case POOR:
                quality = "poor";
                break;
        }      
        
        //Create each tip calculator instance through the TipCalculator interface (Liskov)
        TipCalculator bagTipCalculator = new BaggageServiceTipCalculator(serviceQual, bagNum);
        TipCalculator foodTipCalculator = new FoodServiceTipCalculator(serviceQual, billAmt);
        
        //Create instance of high-level class
        
        TipCalculatorService CalcService = new TipCalculatorService();
        //TipCalculatorService CalcService = new TipCalculatorService(footTipCalculator);
        
        //formatting purposes
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        
        //Print out results
        System.out.println("If the service is " + quality + ", the tip amount for a baggage handler with " + bagNum + " bags is: " + nf.format(CalcService.calculateTip(bagTipCalculator)));        
        System.out.println("If the service is " + quality + ", the tip amount for a restaurant bill of " + nf.format(billAmt) + " is: " +nf.format(CalcService.calculateTip(foodTipCalculator)));
    }

}
